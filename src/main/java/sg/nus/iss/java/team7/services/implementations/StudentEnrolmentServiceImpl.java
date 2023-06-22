package sg.nus.iss.java.team7.services.implementations;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.models.StudentEnrolment;
import sg.nus.iss.java.team7.repos.StudentEnrolmentRepository;
import sg.nus.iss.java.team7.services.StudentEnrolmentService;
@Service
public class StudentEnrolmentServiceImpl implements StudentEnrolmentService{
    @Autowired StudentEnrolmentRepository studentEnrolmentRepository;
    @Override
    public void commitAllStudentEnrolment(List<StudentEnrolment> studentEnrolments,Date date){
        studentEnrolments.forEach(s->s.setEnrolment_date(date));
        for(StudentEnrolment student:studentEnrolments)
        {
            studentEnrolmentRepository.save(student);
        }
        
    }
    
}
