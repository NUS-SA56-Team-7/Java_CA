package sg.nus.iss.java.team7.models;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("admin")
public class Administrator extends Account {
    
    

}
