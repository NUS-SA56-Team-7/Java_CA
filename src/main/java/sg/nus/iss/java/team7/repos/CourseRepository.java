package sg.nus.iss.java.team7.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.keys.CourseId;

public interface CourseRepository extends JpaRepository<Course,CourseId> {

}
