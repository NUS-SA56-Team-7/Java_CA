package sg.nus.iss.java.team7.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import sg.nus.iss.java.team7.exceptions.ResourceNotFoundException;
import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.services.CourseService;

public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseRepository repoCourse;

    public Course createCourse(Course course) {
        return repoCourse.save(course);
    }

    public Course updateCourse(Long id, Course course) {
        return repoCourse.findById(id)
                .map(existingCourse -> {
                    existingCourse.setId(existingCourse.getId());
                    existingCourse.setCourseName(course.getCourseName());
                    existingCourse.setDescription(course.getDescription());
                    existingCourse.setCourseCredits(course.getCourseCredits());
                    existingCourse.setCourseCapacity(course.getCourseCapacity());
                    existingCourse.setCourseFee(course.getCourseFee());
                    existingCourse.setCourseStartDate(course.getCourseStartDate());
                    existingCourse.setCourseDuration(course.getCourseDuration());
                    existingCourse.setCourseStatus(course.getCourseStatus());
                    existingCourse.setCourseStudent(course.getCourseStudent());
                    existingCourse.setLecturer(course.getLecturer());

                    return repoCourse.save(existingCourse);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Not Found", null));
    }

    public Boolean deleteCourse(Long id) {
        return repoCourse.findById(id)
                .map(existingCourse -> {
                    repoCourse.delete(existingCourse);
                    return true;
                })
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    public List<Course> getAllCourses() {
        List<Course> allCourses = repoCourse.findAll();
        return getCompleteCourses(allCourses);
    }

    public Course getCourseById(Long id) {
        return repoCourse.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    public Long getStudentCountInCourse(Long id) {
        Course course = repoCourse.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException());
        return course.getCourseStudent().stream()
                .map(cs -> cs.getStudent()).count();
    }

    public List<Course> getCompleteCourses(List<Course> courses) {
        System.out.println("Here");
        return courses.stream()
                .map(course -> {
                    Long studentCount = getStudentCountInCourse(course.getId());
                    course.setCourseVacancy(
                            course.getCourseCapacity() - studentCount);
                    course.setCourseEndDate(
                            course.getCourseStartDate().plusDays(course.getCourseDuration()));
                    return course;
                }).toList();
    }
}
