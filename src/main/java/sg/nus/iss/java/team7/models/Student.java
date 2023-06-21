package sg.nus.iss.java.team7.models;

import java.sql.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;






@Entity
@DiscriminatorValue("student")
public class Student extends Account {

    public Student(String email, String password, String first_name, String last_name, String phone_number, Date date_of_birth) {
        super(email, password, first_name, last_name, phone_number, date_of_birth);
        
    }
    private String matric_number;
    public String getMatric_number() {
        return matric_number;
    }
    public void setMatric_number(String matric_number) {
        this.matric_number = matric_number;
    }
    
    
}
