package sg.nus.iss.java.team7.repos;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.java.team7.models.Student;
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query(value = "Select s FROM Student s WHERE matric_number LIKE %:matricNumber%")
    public List<Student> findByMatricNumber(@Param("matricNumber") String matricNumber);

    @Query("select s from Student s join s.courses c where c.id = :courseId")
    List<Student> findByCourseId(@Param("courseId") String courseId);
}
