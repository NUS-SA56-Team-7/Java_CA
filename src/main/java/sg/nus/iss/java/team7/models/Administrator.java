package sg.nus.iss.java.team7.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Administrator {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int admin_id;

    private String email;

    private String password;

    private String admin_first_name;

    private String admin_last_name;

    private String phone_number;

}
