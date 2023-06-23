package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.keys.CourseStudentId;

@Entity
@IdClass(CourseStudentId.class)
@NoArgsConstructor
public class Grading {
    @Id
    private long student_id;

    @Id
    private long course_id;
    
    
    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;
    
    public Grading(Student student, Course course, String grade, String credit) {
        this.student = student;
        this.course = course;
        this.grade = grade;
        this.credit = credit;
        this.course_id = course.getId();
        this.student_id = student.getAccount_id();
    }
    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(columnDefinition = "VARCHAR(2)")
    private String grade;
    @Column(columnDefinition = "VARCHAR(10)")
    private String credit;
    
}
