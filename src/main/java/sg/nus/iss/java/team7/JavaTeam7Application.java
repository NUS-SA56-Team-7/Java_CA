package sg.nus.iss.java.team7;



import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sg.nus.iss.java.team7.models.Administrator;
import sg.nus.iss.java.team7.repos.AdministratorRepository;


@SpringBootApplication
public class JavaTeam7Application {
		
	public static void main(String[] args) {
		SpringApplication.run(JavaTeam7Application.class, args);
	}
@Bean
public CommandLineRunner commandLineRunner(AdministratorRepository adminrep)
{
	return args -> {
		Administrator admin = adminrep.save(new Administrator("223@gmail.com", "12345", "Leroy", "ASd", "123456", new Date(11234)));
	};
}
	
}
