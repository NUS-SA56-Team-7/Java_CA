package sg.nus.iss.java.team7;




import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sg.nus.iss.java.team7.models.Administrator;
import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.models.StudentEnrolment;
import sg.nus.iss.java.team7.repos.AdministratorRepository;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.repos.LecturerRepository;
import sg.nus.iss.java.team7.repos.StudentEnrolmentRepository;
import sg.nus.iss.java.team7.repos.StudentRepository;


@SpringBootApplication
@EnableJpaAuditing
public class JavaTeam7Application {
		
	public static void main(String[] args) {
		SpringApplication.run(JavaTeam7Application.class, args);
	}
	@Bean
	public CommandLineRunner ckCommandLineRunner(CourseRepository crep, LecturerRepository lecturerRepository,StudentRepository sRepository, StudentEnrolmentRepository serep)
	{
		return args -> {
			
			serep.save(new StudentEnrolment(sRepository.findById((long) 1).get(), crep.findById((long) 1).get(), new Date(0), "1234"));
			

		};
	}

	
}
