package sg.nus.iss.java.team7.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.java.team7.models.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator,Integer>{
    
}
