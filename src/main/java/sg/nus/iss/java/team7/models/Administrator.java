package sg.nus.iss.java.team7.models;


import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;



import lombok.NoArgsConstructor;




@Entity
@DiscriminatorValue("admin")
@NoArgsConstructor
public class Administrator extends Account {
   
    public Administrator(String email, String password, String first_name, String last_name, String phone_number, Date date_of_birth) {
        super(email, password, first_name, last_name, phone_number, date_of_birth);
        //TODO Auto-generated constructor stub
    }
    
    

}
