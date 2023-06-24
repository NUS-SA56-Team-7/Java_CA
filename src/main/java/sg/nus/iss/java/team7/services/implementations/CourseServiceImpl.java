package sg.nus.iss.java.team7.services.implementations;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.exceptions.ResourceNotFoundException;
import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.repos.StudentEnrolmentRepository;
import sg.nus.iss.java.team7.services.CourseService;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseRepository courseRepository;

	@Autowired
	StudentEnrolmentRepository studentEnrolmentRepository;
 
	@Override
	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}

	@Override
	public List<Course> getAvailableCourses(Long studentId) {
		return getUpToDateCourses(studentId).stream()
				.filter(course -> {
					return !studentEnrolmentRepository.existsByStudentIdAndCourseId(studentId, course.getId());
				})
				.toList();
	}

	@Override
	public Course getCourseById(Long id) {
		return courseRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}

	public List<Course> getUpToDateCourses(Long studentId) {
		List<Course> availableCourses = getAllCourses();
		availableCourses.forEach(course -> calculateCourseStatus(course));
		return courseRepository.saveAll(availableCourses);
	}

	public Long getStudentEnrolmentCount(Long id) {
		Course course = courseRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException());
		return course.getStudentEnrolments().stream()
				.map(studentEnrolment -> studentEnrolment.getStudent()).count();
	}

	public void calculateCourseStatus(Course course) {
		LocalDate today = LocalDate.now();
		Long thresholdCapacity = (long) (course.getCourseCapacity() * 0.2);

		course.setEnrolmentStartDate(course.getCourseStartDate().minusDays(30));
		course.setEnrolmentEndDate(course.getCourseStartDate().minusDays(10));
		course.setCourseVacancy((long) course.getCourseCapacity() - getStudentEnrolmentCount(course.getId()));
		course.setCourseEndDate(course.getCourseStartDate().plusMonths(course.getCourseDuration()));

		if (today.isAfter(course.getEnrolmentStartDate()) && today.isBefore(course.getEnrolmentEndDate())) {
			if (getStudentEnrolmentCount(course.getId()) > (long) 0) {
				// for course capacity full
				if ((long) course.getCourseCapacity() == getStudentEnrolmentCount(course.getId())) {
					course.setCourseStatus(2);
				}
				// for course vacancy low
				else if (course.getCourseVacancy() <= thresholdCapacity) {
					course.setCourseStatus(1);
				}
			} else {
				course.setCourseStatus(0);
			}
		} else {
			// for enrolment closed
			if (today.isAfter(course.getEnrolmentEndDate()) && today.isBefore(course.getCourseStartDate())) {
				course.setCourseStatus(3);
			}

			// for onging course
			else if (today.isAfter(course.getCourseStartDate()) && today.isBefore(course.getCourseEndDate())) {
				course.setCourseStatus(4);
			}

			// for completed course
			else if (today.isAfter(course.getCourseEndDate())) {
				course.setCourseStatus(5);
			}

			// for upcoming course
			else if (today.isBefore(course.getEnrolmentStartDate())){
				course.setCourseStatus(6);
			}
		}
	}

	@Override
	public List<Course> getAttendingCourses(Long studentId) {
		return getAllCourses().stream()
				.filter(course -> {
					return studentEnrolmentRepository.existsByStudentIdAndCourseId(studentId, course.getId());
				})
				.toList();
	}
}
