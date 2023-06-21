package sg.nus.iss.java.team7.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.keys.CourseStudentId;

@Entity
@IdClass(CourseStudentId.class)
@NoArgsConstructor
public class StudentEnrolment {
    @Id
    private Student student;
    @Id
    private Course course;
    
    private Date enrolment_date;

    private int status;
}
