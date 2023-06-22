package sg.nus.iss.java.team7.models;

import java.sql.Date;
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
@Table(name = "student")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "VARCHAR(15) UNIQUE NOT NULL")
	private String matric_number;

	@Column(columnDefinition = "VARCHAR(30) NOT NULL")
	private String first_name;

	@Column(columnDefinition = "VARCHAR(30) NOT NULL")
	private String last_name;

	@Column(columnDefinition = "VARCHAR(20)")
	private String phoneNumber;

	@Column(columnDefinition = "VARCHAR(1)")
	private String gender;

	@Column(columnDefinition = "DATE")
	private Date date_of_birth;
	
	@OneToMany(targetEntity = CourseStudent.class, mappedBy = "student")
	private List<CourseStudent> courseStudents;
	
	@OneToMany(targetEntity = StudentEnrolment.class, mappedBy = "student")
	private List<StudentEnrolment> studentEnrolments;
}