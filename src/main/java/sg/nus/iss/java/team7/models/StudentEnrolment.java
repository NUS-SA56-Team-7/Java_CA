package sg.nus.iss.java.team7.models;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.keys.CourseStudentId;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(CourseStudentId.class)
public class StudentEnrolment {
    
    @Id
    private long student_id;
    @Id
    private long course_id;
    
    @ManyToOne
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student student;
    
    @ManyToOne
    @MapsId("course_id")
    @JoinColumn(name = "course_Id")
    private Course course;
    

    private Date enrolment_date;
    @Column(columnDefinition="VARCHAR(10)")
    private String status;
    public StudentEnrolment(Student student, Course course, Date enrolment_date, String status) {
        this.student = student;
        this.course = course;
        this.course_id = course.getId();
        this.student_id = student.getAccount_id();
        this.enrolment_date = enrolment_date;
        this.status = status;
    }   
}
