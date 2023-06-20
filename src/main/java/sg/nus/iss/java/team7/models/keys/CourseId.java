package sg.nus.iss.java.team7.models.keys;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.models.Lecturer;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseId implements Serializable{
    private long id;
    @ManyToOne
    @JoinColumn(name="lecturer_id")
    private Lecturer lecturer;
    
}