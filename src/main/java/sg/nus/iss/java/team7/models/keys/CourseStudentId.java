package sg.nus.iss.java.team7.models.keys;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Student;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id")
    private Course course;

}
