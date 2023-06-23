package sg.nus.iss.java.team7.models.keys;

import java.io.Serializable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Student;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentId implements Serializable {

    private Student student;


    private Course course;

}
