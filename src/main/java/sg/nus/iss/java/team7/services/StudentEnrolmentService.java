package sg.nus.iss.java.team7.services;

import java.util.List;

import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.models.StudentEnrolment;

public interface StudentEnrolmentService {
    StudentEnrolment createStudentEnrolment(StudentEnrolment studentEnrolment);

    Boolean checkEnrolled(Long studentId, Long courseId);

    List<Student> attendingStudents(Long courseId);
}
