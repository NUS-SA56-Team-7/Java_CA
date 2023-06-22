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
    CourseRepository courseRepository;
    @Override
    public List<Course> findAllCourse(){
        return (List<Course>) courseRepository.findAll();
    }
    @Override
    public Course findCourseByName(String name)
    {
        return (Course) courseRepository.findByCourseName(name);
    }

}
