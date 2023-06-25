package sg.nus.iss.java.team7.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.services.CourseService;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(String id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public Course findCourseByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public List<Course> findCoursesByLecturerId(String lecturerId) {
        return courseRepository.findByLecturerId(lecturerId);
    }

    @Override
    public void saveOrUpdateCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void deleteCourseById(String id) {
        courseRepository.deleteById(id);
    }
