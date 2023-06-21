package sg.nus.iss.java.team7.models.keys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudentId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "course_id")
	private Long course_id;
	
	@Column(name = "student_id")
	private Long student_id;
}
