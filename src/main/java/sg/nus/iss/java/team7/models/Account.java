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
import javax.persistence.InheritanceType;
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
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
@DiscriminatorColumn(name = "account_type")
public abstract class Account {
    @Transient
    @Autowired
    protected PasswordEncoderService encoder = new PasswordEncoderServiceImpl();
    
    protected final void setEncoder(PasswordEncoderService encoder){
        this.encoder=encoder;
    }
    @Id
    @GeneratedValue(strategy=GenerationType.TABLE)
    protected long account_id;
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
    protected String email;
    @Column(columnDefinition="VARCHAR(60) NOT NULL")
    protected String password;

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
    protected String first_name;

    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    protected String last_name;
    
    @Column(columnDefinition="VARCHAR(45) NOT NULL")
    protected String phone_number;
    @Column(columnDefinition = "DATE NOT NULL")
    protected Date date_of_birth;
    @CreatedDate
    protected Date created_at;
    @LastModifiedDate
    protected Date updated_at;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((encoder == null) ? 0 : encoder.hashCode());
        result = prime * result + (int) (account_id ^ (account_id >>> 32));
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((first_name == null) ? 0 : first_name.hashCode());
        result = prime * result + ((last_name == null) ? 0 : last_name.hashCode());
        result = prime * result + ((phone_number == null) ? 0 : phone_number.hashCode());
        result = prime * result + ((date_of_birth == null) ? 0 : date_of_birth.hashCode());
        result = prime * result + ((created_at == null) ? 0 : created_at.hashCode());
        result = prime * result + ((updated_at == null) ? 0 : updated_at.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (encoder == null) {
            if (other.encoder != null)
                return false;
        } else if (!encoder.equals(other.encoder))
            return false;
        if (account_id != other.account_id)
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (first_name == null) {
            if (other.first_name != null)
                return false;
        } else if (!first_name.equals(other.first_name))
            return false;
        if (last_name == null) {
            if (other.last_name != null)
                return false;
        } else if (!last_name.equals(other.last_name))
            return false;
        if (phone_number == null) {
            if (other.phone_number != null)
                return false;
        } else if (!phone_number.equals(other.phone_number))
            return false;
        if (date_of_birth == null) {
            if (other.date_of_birth != null)
                return false;
        } else if (!date_of_birth.equals(other.date_of_birth))
            return false;
        if (created_at == null) {
            if (other.created_at != null)
                return false;
        } else if (!created_at.equals(other.created_at))
            return false;
        if (updated_at == null) {
            if (other.updated_at != null)
                return false;
        } else if (!updated_at.equals(other.updated_at))
            return false;
        return true;
    }
}
