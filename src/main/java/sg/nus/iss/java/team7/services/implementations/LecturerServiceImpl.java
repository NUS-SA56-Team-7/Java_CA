package sg.nus.iss.java.team7.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.exceptions.ResourceNotFoundException;
import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.repos.LecturerRepository;
import sg.nus.iss.java.team7.services.CourseService;
import sg.nus.iss.java.team7.services.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {
    @Autowired
	LecturerRepository lecturerRepository;

    @Autowired
	CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

    @Override
    public List<Course> getTeachingCourses(Long lecturerId) {
        return courseService.getAllCourses().stream()
                            .filter(course -> 
                                course.getLecturer().getId().equals(lecturerId)
                            ).toList();
    }

    @Override
    public Lecturer getLecturerById(Long lecturerId) {
        return lecturerRepository.findById(lecturerId)
                .orElseThrow(() -> new ResourceNotFoundException());
    }
    
}
