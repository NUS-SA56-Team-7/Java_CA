package sg.nus.iss.java.team7.models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("admin")
public class Administrator extends Account {

    public Administrator(String email, String password, String first_name, String last_name, String phone_number) {
        super(email, password, first_name, last_name, phone_number);
        //TODO Auto-generated constructor stub
    }
    
    

}
