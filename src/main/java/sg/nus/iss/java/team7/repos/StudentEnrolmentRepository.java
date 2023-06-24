package sg.nus.iss.java.team7.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.nus.iss.java.team7.models.StudentEnrolment;

@Repository
public interface StudentEnrolmentRepository extends JpaRepository<StudentEnrolment, Long> {
    boolean existsByStudentIdAndCourseId(Long studentId, Long courseId);
}
