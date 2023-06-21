package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;


import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.keys.CourseStudentId;

@Entity
@IdClass(CourseStudentId.class)
@NoArgsConstructor
public class Grading {
    @Id
    @Column(name = "student_id")
    private Student student;
    @Id
    @Column(name = "course_id")
    private Course course;

    @Column(columnDefinition = "VARCHAR(2)")
    private String grade;
    @Column(columnDefinition = "VARCHAR(10)")
    private String credit;
    
}
