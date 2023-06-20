package sg.nus.iss.java.team7.models;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("lecturer")
public class Lecturer extends Account {


@OneToMany
@JoinColumn(name="id",columnDefinition = "INTEGER NOT NULL")
private List<Course> courses;

}
