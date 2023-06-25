package sg.nus.iss.java.team7.services;

import java.util.List;

import sg.nus.iss.java.team7.models.Course;

public interface CourseService {

    List<Course> findAllCourses();


    Course findCourseById(String id);


    Course findCourseByName(String name);


    List<Course> findCoursesByLecturerId(String lecturerId);


    void saveOrUpdateCourse(Course course);


    void deleteCourseById(String id);
}
