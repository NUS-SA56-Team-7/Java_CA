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

	@Column(columnDefinition = "VARCHAR(30) NOT NULL")
	private String lecturer_first_name;

	@Column(columnDefinition = "VARCHAR(30) NOT NULL")
	private String lecturer_last_name;

	@Column(columnDefinition = "VARCHAR(15) NOT NULL")
	private String lecturer_title;

	@Column(columnDefinition = "VARCHAR(10) NOT NULL")
	private String lecturer_code;

	@Column(columnDefinition = "VARCHAR(15) NOT NULL")
	private String lecturer_designation;

	@Column(columnDefinition = "VARCHAR(1)")
	private String lecturer_gender;

	@Column(columnDefinition = "VARCHAR(20)")
	private String lecturer_phone_number;
	
	@OneToMany(targetEntity = Course.class, mappedBy = "lecturer")
	private List<Course> courses;
}
