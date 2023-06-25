package sg.nus.iss.java.team7.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.java.team7.models.Course;

public interface CourseRepository extends JpaRepository<Course,Long> {
    @Query("SELECT c FROM Course c WHERE c.course_name LIKE :CourseName")
    public Course findByCourseName(@Param("CourseName")String name);

    //Course findByName(String name);

    List<Course> findByLecturerId(String lecturerId);
}
