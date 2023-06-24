package sg.nus.iss.java.team7.services;

import java.util.List;

import sg.nus.iss.java.team7.models.Course;

public interface CourseService {
	List<Course> getAllCourses();
	
	List<Course> getAvailableCourses(Long studentId);

	Course getCourseById(Long id);

	List<Course> getAttendingCourses(Long studentId);
}
