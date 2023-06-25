package sg.nus.iss.java.team7.services;

import java.util.List;

import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Lecturer;

public interface LecturerService {
    List<Course> getTeachingCourses(Long lecturerId);

    Lecturer getLecturerById(Long lecturerId);
}
