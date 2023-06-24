package sg.nus.iss.java.team7.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "studentenrolment", uniqueConstraints = {@UniqueConstraint(columnNames = {"course_id", "student_id"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentEnrolment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	@JsonIgnore
	private Course course;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	@JsonIgnore
	private Student student;
	
	@Column(columnDefinition = "Date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrolmentDate;

	@Column(columnDefinition = "TINYINT")
	private Integer status = 1;
}
