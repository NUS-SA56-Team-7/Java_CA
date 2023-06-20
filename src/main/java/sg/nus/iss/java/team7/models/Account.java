package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import lombok.Data;

@Entity
@Inheritance
@DiscriminatorColumn(name = "account_type")
@Data
public abstract class Account {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int account_id;
    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String email;
    @Column(columnDefinition="BINARY(32) NOT NULL")
    private String password;

    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String first_name;

    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String last_name;
    
    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String phone_number;
}
