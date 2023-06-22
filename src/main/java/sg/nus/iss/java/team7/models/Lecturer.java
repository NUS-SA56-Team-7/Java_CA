package sg.nus.iss.java.team7.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "lecturer")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Lecturer extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "lecturer_code")
	private String code;
	
	@Column(name = "lecturer_title")
	private String title;
	
	@Column(name = "lecturer_first_name")
	private String firstName;
	
	@Column(name = "lecturer_last_name")
	private String lastName;
	
	@Column(name = "lecturer_designation")
	private String designation;
	
	@Column(name = "lecturer_gender")
	private String gender;
	
	@Column(name = "lecturer_phone_number")
	private String phone;
	
	// @OneToMany(targetEntity = Course.class, mappedBy = "lecturer")
	// private List<Course> courses;
}