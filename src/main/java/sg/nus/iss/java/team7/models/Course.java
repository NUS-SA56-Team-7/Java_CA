package sg.nus.iss.java.team7.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "NVARCHAR(50) UNIQUE NOT NULL")
	private String course_name;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String description;

	@Column(columnDefinition = "TINYINT NOT NULL")
	private Integer course_capacity;

	@Column(columnDefinition = "TINYINT NOT NULL")
	private Integer course_duration;

	@Column(columnDefinition = "TINYINT NOT NULL")
	private Integer course_fee;

	@Column(columnDefinition = "DATE NOT NULL")
	private Date course_start_date;

	@Column(columnDefinition = "VARCHAR(1)")
	private String course_status;
	
	@OneToMany(targetEntity = CourseStudent.class, mappedBy = "course")
	private List<CourseStudent> courseStudents;
	
	@OneToMany(targetEntity = StudentEnrolment.class, mappedBy = "course")
	private List<StudentEnrolment> studentEnrolments;
	
	@ManyToOne
	@JoinColumn(name = "lecturer_id")
	private Lecturer lecturer;
}
