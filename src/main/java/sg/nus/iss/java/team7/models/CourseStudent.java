package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.keys.CourseStudentId;

@Entity
@Table(name = "grading")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudent {
	@EmbeddedId
	private CourseStudentId id = new CourseStudentId();
	
	@ManyToOne
	@MapsId("course_id")
	@JsonIgnore
	private Course course;
	
	@ManyToOne
	@MapsId("student_id")
	@JsonIgnore
	private Student student;

	@Column(columnDefinition = "VARCHAR(5)")
	private String credit;

	@Column(columnDefinition = "VARCHAR(5)")
	private String grade;
}
