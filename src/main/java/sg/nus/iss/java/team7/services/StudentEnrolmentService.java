package sg.nus.iss.java.team7.services;

import java.util.Date;
import java.util.List;

import sg.nus.iss.java.team7.models.StudentEnrolment;

public interface StudentEnrolmentService {
    public void commitAllStudentEnrolment(List<StudentEnrolment> studentEnrolments,Date date);
}
