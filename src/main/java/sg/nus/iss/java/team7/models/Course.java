package sg.nus.iss.java.team7.models;

import java.sql.Date;
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

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@Column(columnDefinition = "SMALLINT NOT NULL")
	private Integer courseCredits;
	
	@Column(columnDefinition = "SMALLINT NOT NULL")
	private Integer courseCapacity;
	
	@Column(columnDefinition = "SMALLINT NOT NULL")
	private Integer courseFee;
	
	@Column(columnDefinition = "DATE NOT NULL")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate courseStartDate;
	
	@Column(columnDefinition = "SMALLINT NOT NULL")
	private Integer courseDuration;
	
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
	@Column(columnDefinition = "TINYINT NOT NULL")
	private Integer courseStatus = 0;
	
	@OneToMany(targetEntity = CourseStudent.class, mappedBy = "course")
	private List<CourseStudent> courseStudent;
	
	@ManyToOne
	private Lecturer lecturer;
	
	@Transient
	private LocalDate courseEndDate;
	
	@Transient
	private Long courseVacancy;
}