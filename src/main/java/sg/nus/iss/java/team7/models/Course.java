package sg.nus.iss.java.team7.models;

import java.time.LocalDate;
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
import javax.persistence.Transient;

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
	private String courseName;

	@Column(columnDefinition = "NVARCHAR(255)")
	private String description;

	@Column(columnDefinition = "TINYINT NOT NULL")
	private Integer courseCapacity;

	@Column(columnDefinition = "TINYINT NOT NULL")
	private Integer courseDuration;

	@Column(columnDefinition = "INT NOT NULL")
	private Integer courseFee;

	@Column(columnDefinition = "DATE NOT NULL")
	private LocalDate courseStartDate;

	@Column(columnDefinition = "TINYINT")
	private Integer courseStatus = 0;
	
	@OneToMany(targetEntity = CourseStudent.class, mappedBy = "course")
	private List<CourseStudent> courseStudents;
	
	@OneToMany(targetEntity = StudentEnrolment.class, mappedBy = "course")
	private List<StudentEnrolment> studentEnrolments;
	
	@ManyToOne
	@JoinColumn(name = "lecturerId")
	private Lecturer lecturer;

	/***
	    0 = AVAILABLE
	    1 = LOW_VACANCY
	    2 = FULL
	    3 = ENROLLMENT_CLOSED
	    4 = ONGOING
	    5 = COMPLETED
	    6 = UPCOMING
	    7 = CANCELLED
    ***/

	@Transient
	private LocalDate courseEndDate;

	@Transient
	private LocalDate enrolmentStartDate;

	@Transient
	private LocalDate enrolmentEndDate;
	
	@Transient
	private Long courseVacancy;
}
