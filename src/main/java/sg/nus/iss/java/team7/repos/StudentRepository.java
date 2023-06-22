package sg.nus.iss.java.team7.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sg.nus.iss.java.team7.models.Student;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = "SELECT s.account_id FROM Student s")
    public List<Long> findNonEnrolledStudent();
}
