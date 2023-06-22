package sg.nus.iss.java.team7.services;

import java.util.List;

import sg.nus.iss.java.team7.models.Course;

public interface CourseService  {

    public List<Course> findAllCourse();
    public Course findCourseByName( String name);
}
