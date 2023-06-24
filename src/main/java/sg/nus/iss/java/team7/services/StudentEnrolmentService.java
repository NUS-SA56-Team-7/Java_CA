package sg.nus.iss.java.team7.services;

import sg.nus.iss.java.team7.models.StudentEnrolment;

public interface StudentEnrolmentService {
    StudentEnrolment createStudentEnrolment(StudentEnrolment studentEnrolment);

    Boolean checkEnrolled(Long studentId, Long courseId);
}
