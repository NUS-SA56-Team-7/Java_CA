package sg.nus.iss.java.team7.models;

<<<<<<< HEAD
import java.sql.Date;
=======
import java.util.Date;
>>>>>>> 1c04c192cdc1f6706905863620e2f4d587920c81
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.NoArgsConstructor;

@Entity
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @ManyToOne
    @JoinColumn(name ="lecturer_id",columnDefinition = "INTEGER NOT NULL")
    private Lecturer lecturer;
    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String course_name;
    @Column(columnDefinition="VARCHAR(300) NOT NULL")
    private String description;
    private int course_capacity;
    @Column(name ="course_duration_in_days")
    private int course_duration;
    private int course_fee;
    private Date course_start_date;
    @Column(columnDefinition="VARCHAR(10) NOT NULL")
    private String course_status;
    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date updated_at;
    @OneToMany(mappedBy = "course")
    private List<RequestUpdate> requestUpdates;

   
    public Course(Lecturer lecturer, String course_name, String description, int course_capacity, int course_duration,
            int course_fee, Date course_start_date, String course_status) {
        this.lecturer = lecturer;
        this.course_name = course_name;
        this.description = description;
        this.course_capacity = course_capacity;
        this.course_duration = course_duration;
        this.course_fee = course_fee;
        this.course_start_date = course_start_date;
        this.course_status = course_status;
    }
    public Lecturer getLecturer() {
        return lecturer;
    }
    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }
    public String getCourse_name() {
        return course_name;
    }
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCourse_capacity() {
        return course_capacity;
    }
    public void setCourse_capacity(int course_capacity) {
        this.course_capacity = course_capacity;
    }
    public int getCourse_duration() {
        return course_duration;
    }
    public void setCourse_duration(int course_duration) {
        this.course_duration = course_duration;
    }
    public int getCourse_fee() {
        return course_fee;
    }
    public void setCourse_fee(int course_fee) {
        this.course_fee = course_fee;
    }
    public Date getCourse_start_date() {
        return course_start_date;
    }
    public void setCourse_start_date(Date course_start_date) {
        this.course_start_date = course_start_date;
    }
    public String getCourse_status() {
        return course_status;
    }
    public void setCourse_status(String course_status) {
        this.course_status = course_status;
    }


}
