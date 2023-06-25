package sg.nus.iss.java.team7.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.java.team7.models.Lecturer;

public interface LecturerRepository extends JpaRepository<Lecturer,Long>{

    List<Lecturer> findByName(String name);
}
