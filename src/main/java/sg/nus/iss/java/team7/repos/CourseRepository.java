package sg.nus.iss.java.team7.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.java.team7.models.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {

}
