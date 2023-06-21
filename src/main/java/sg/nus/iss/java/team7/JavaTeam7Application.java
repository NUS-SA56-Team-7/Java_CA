package sg.nus.iss.java.team7;



import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import sg.nus.iss.java.team7.models.Administrator;
import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.repos.AdministratorRepository;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.repos.LecturerRepository;


@SpringBootApplication
@EnableJpaAuditing
public class JavaTeam7Application {
		
	public static void main(String[] args) {
		SpringApplication.run(JavaTeam7Application.class, args);
	}
@Bean
public CommandLineRunner commandLineRunner(AdministratorRepository adminrep, CourseRepository courseRep,LecturerRepository lecRep)
{
	return args -> {
		Administrator admin = adminrep.save(new Administrator("223@gmail.com", "12345", "Leroy", "ASd", "123456", new Date(11234)));
		Lecturer lecturer = lecRep.save(new Lecturer("est@meme.com","123452","LOl","awe","123456",new Date(-123)));
		lecturer.setLecturer_title("op");
		lecturer.setLecturer_designation("meme");
		lecturer.setLecturer_code("123456");
		lecRep.save(lecturer);
		Course course = courseRep.save(new Course(lecturer,"aspel","too Hard",123,1,2123,new Date(234),"Nobody"));
	};
}
	
}
