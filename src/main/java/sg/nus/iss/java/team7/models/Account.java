package sg.nus.iss.java.team7.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.NoArgsConstructor;
import sg.nus.iss.java.team7.services.PasswordEncoderService;
import sg.nus.iss.java.team7.services.implementations.PasswordEncoderServiceImpl;


@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Inheritance
@DiscriminatorColumn(name = "account_type")
public abstract class Account {
    @Transient
    @Autowired
    protected PasswordEncoderService encoder = new PasswordEncoderServiceImpl();
    
    protected final void setEncoder(PasswordEncoderService encoder){
        this.encoder=encoder;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long account_id;
    public Account(String email, String password, String first_name, String last_name, String phone_number, Date date_of_birth) {
        
        this.email = email;
        this.password = encoder.passwordEncoder(password);
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.date_of_birth = date_of_birth;
    }
    @Transient
    public String getAccountType(){
        return getClass().getAnnotation(DiscriminatorValue.class).value();
    }
    @Column(columnDefinition="VARCHAR(45) NOT NULL",unique = true)
    private String email;
    @Column(columnDefinition="VARCHAR(60) NOT NULL")
    private String password;

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(long account_id) {
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
       
        this.password = encoder.passwordEncoder(password);
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
    @Column(columnDefinition = "DATE NOT NULL")
    private Date date_of_birth;
    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date updated_at;
}
