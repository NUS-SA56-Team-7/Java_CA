package sg.nus.iss.java.team7.models;


import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.services.PasswordEncoderService;




@Entity
@DiscriminatorValue("admin")
@NoArgsConstructor
public class Administrator extends Account {
    @Autowired
    @Transient
    private PasswordEncoderService encode;
    public Administrator(String email, String password, String first_name, String last_name, String phone_number, Date date_of_birth) {
        super(email, password, first_name, last_name, phone_number, date_of_birth);
        //TODO Auto-generated constructor stub
    }
    
    

}
