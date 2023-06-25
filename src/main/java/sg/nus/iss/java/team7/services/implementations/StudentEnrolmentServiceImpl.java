package sg.nus.iss.java.team7.services.implementations;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.exceptions.ResourceNotFoundException;
import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.models.StudentEnrolment;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.repos.StudentEnrolmentRepository;
import sg.nus.iss.java.team7.services.StudentEnrolmentService;

@Service
public class StudentEnrolmentServiceImpl implements StudentEnrolmentService {
    @Autowired
    private StudentEnrolmentRepository studentEnrolmentRepository;

    @Autowired
    private CourseServiceImpl courseServiceImpl;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public StudentEnrolment createStudentEnrolment(StudentEnrolment studentEnrolment) {
        Course course = studentEnrolment.getCourse();
        studentEnrolmentRepository.saveAndFlush(studentEnrolment);

        Long courseId = course.getId();
        Long thresholdCapacity = (long) (course.getCourseCapacity() * 0.2);
        course.setCourseVacancy((long) course.getCourseCapacity() - (courseServiceImpl.getStudentEnrolmentCount(course.getId())));

        if ((long) course.getCourseCapacity() == (courseServiceImpl.getStudentEnrolmentCount(course.getId()))) {
            System.out.println("now full");
            courseRepository.findById(courseId)
            .ifPresent(c -> {
                c.setCourseStatus(2);
                courseRepository.save(c);
            });
        } else if (course.getCourseVacancy() <= thresholdCapacity) {
            System.out.println("reach threshold");
            courseRepository.findById(courseId)
            .ifPresent(c -> {
                c.setCourseStatus(1);
                courseRepository.save(c);
            });
        }
        return studentEnrolment;
    }

    @Override
    public Boolean checkEnrolled(Long studentId, Long courseId) {
        return studentEnrolmentRepository.existsByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Student> attendingStudents(Long courseId) {
        Course course = courseRepository.findById(courseId)
                        .orElseThrow(() -> new ResourceNotFoundException());

        List<StudentEnrolment> enrolments = course.getStudentEnrolments();
        List<Student> studentsAttending = enrolments.stream()
                                            .map(StudentEnrolment::getStudent)
                                            .collect(Collectors.toList());
        return studentsAttending;
    }
    
}
