package sg.nus.iss.java.team7.models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import org.springframework.beans.factory.annotation.Autowired;

import sg.nus.iss.java.team7.services.PasswordEncoderService;


@Entity
@Inheritance
@DiscriminatorColumn(name = "account_type")
public abstract class Account {
    @Autowired
    PasswordEncoderService encoder;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int account_id;
    public Account(String email, String password, String first_name, String last_name, String phone_number) {
        this.email = email;
        this.password = encoder.passwordEncoder(password);
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }

    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String email;
    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String password;

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String encodepassword = encoder.passwordEncoder(password);
        this.password = encodepassword;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String first_name;

    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String last_name;
    
    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    private String phone_number;
}
