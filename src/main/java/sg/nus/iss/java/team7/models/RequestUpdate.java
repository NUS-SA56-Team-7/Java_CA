package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class RequestUpdate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long request_update_id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecturer lecturer;

    @Column(columnDefinition="VARCHAR(400)")
    private String reason;
    
    
}
