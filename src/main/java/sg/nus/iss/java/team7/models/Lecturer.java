package sg.nus.iss.java.team7.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Lecturer {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private long lecturer_id;

@OneToMany
@JoinColumn(name="id")
private List<Course> courses;
}
