package sg.nus.iss.java.team7.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CollectionId;

import lombok.NoArgsConstructor;


@Entity
@DiscriminatorValue("lecturer")
@NoArgsConstructor
public class Lecturer extends Account {


public Lecturer(String email, String password, String first_name, String last_name, String phone_number, Date date_of_birth) {
        super(email, password, first_name, last_name, phone_number, date_of_birth);
        
    }
@Column(columnDefinition = "VARCHAR(50) NOT NULL")
private String lecturer_title;
@Column(columnDefinition = "VARCHAR(50) NOT NULL")
private String lecturer_code;
@Column(columnDefinition = "VARCHAR(50) NOT NULL")
private String lecturer_designation;
@OneToMany
@JoinColumn(name="id")
private List<Course> courses;
@OneToMany(mappedBy = "lecturer")
private List<RequestUpdate> requestUpdates;

public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getLecturer_title() {
        return lecturer_title;
    }

    public void setLecturer_title(String lecturer_title) {
        this.lecturer_title = lecturer_title;
    }

    public String getLecturer_code() {
        return lecturer_code;
    }

    public void setLecturer_code(String lecturer_code) {
        this.lecturer_code = lecturer_code;
    }

    public String getLecturer_designation() {
        return lecturer_designation;
    }

    public void setLecturer_designation(String lecturer_designation) {
        this.lecturer_designation = lecturer_designation;
    }

    public List<RequestUpdate> getRequestUpdates() {
        return requestUpdates;
    }

    public void setRequestUpdates(List<RequestUpdate> requestUpdates) {
        this.requestUpdates = requestUpdates;
    }

}
