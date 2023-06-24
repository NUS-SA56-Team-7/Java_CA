package sg.nus.iss.java.team7.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sg.nus.iss.java.team7.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
