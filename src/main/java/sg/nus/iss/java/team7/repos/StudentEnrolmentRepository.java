package sg.nus.iss.java.team7.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.java.team7.models.StudentEnrolment;
import sg.nus.iss.java.team7.models.keys.CourseStudentId;


public interface StudentEnrolmentRepository extends JpaRepository<StudentEnrolment,Long>{
    
}