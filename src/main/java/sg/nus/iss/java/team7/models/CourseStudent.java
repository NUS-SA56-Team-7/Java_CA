package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "grading", uniqueConstraints = {@UniqueConstraint(columnNames =  {"course_id", "student_id"})})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@MapsId("courseId")
	@JsonIgnore
	private Course course;
	
	@ManyToOne
	@MapsId("studentId")
	@JsonIgnore
	private Student student;

	@Column(columnDefinition = "TINYINT")
	private Integer credit;

	@Column(columnDefinition = "VARCHAR(1)")
	private String grade;
}
