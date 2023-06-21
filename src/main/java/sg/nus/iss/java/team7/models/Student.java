package sg.nus.iss.java.team7.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("student")
@NoArgsConstructor
public class Student extends Account {

    public Student(String email, String password, String first_name, String last_name, String phone_number, Date date_of_birth) {
        super(email, password, first_name, last_name, phone_number, date_of_birth);
        
    }
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String matric_number;
    public String getMatric_number() {
        return matric_number;
    }
    public void setMatric_number(String matric_number) {
        this.matric_number = matric_number;
    }
    
    
}
