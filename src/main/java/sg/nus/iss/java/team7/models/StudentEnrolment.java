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

import org.hibernate.annotations.NaturalId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.keys.CourseStudentId;

@Entity
@IdClass(CourseStudentId.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEnrolment {
    @Id
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
    @Id
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "course_Id")
    private Course course;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date enrolment_date;
    @Column(columnDefinition="VARCHAR(10)")
    private String status;
    public StudentEnrolment(Student student, Course course, Date enrolment_date, String status) {
        this.student = student;
        this.course = course;
        this.enrolment_date = enrolment_date;
        this.status = status;
    }
}
