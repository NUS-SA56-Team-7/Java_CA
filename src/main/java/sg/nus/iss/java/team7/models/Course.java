package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.keys.CourseId;

@Entity
@Data
@IdClass(CourseId.class)
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id
    @Column(name = "lecturer_id")
    private Lecturer lecturer;


}
