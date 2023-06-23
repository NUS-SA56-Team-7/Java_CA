package sg.nus.iss.java.team7.models.keys;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseStudentId implements Serializable {

    private long student_id;


    private long course_id;

}
