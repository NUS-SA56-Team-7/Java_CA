package sg.nus.iss.java.team7.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
@DiscriminatorValue("lecturer")
public class Lecturer extends Account {


public Lecturer(String email, String password, String first_name, String last_name, String phone_number) {
        super(email, password, first_name, last_name, phone_number);
        //TODO Auto-generated constructor stub
    }

public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }



@OneToMany
@JoinColumn(name="id",columnDefinition = "INTEGER NOT NULL")
private List<Course> courses;

}
