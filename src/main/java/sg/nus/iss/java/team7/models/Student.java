package sg.nus.iss.java.team7.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.apache.catalina.startup.RealmRuleSet;

import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("student")
@NoArgsConstructor
public class Student extends Account {
    
    public Student(String email, String password, String first_name, String last_name, String phone_number, Date date_of_birth, String matric_number) {
        super(email, password, first_name, last_name, phone_number, date_of_birth);
        this.matric_number = matric_number;
        
    }
    @Column(columnDefinition = "VARCHAR(50) NOT NULL")
    private String matric_number;
    public String getMatric_number() {
        return matric_number;
    }
    public void setMatric_number(String matric_number) {
        this.matric_number = matric_number;
    }
    @OneToMany(mappedBy = "student",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<StudentEnrolment> studentEnrolment;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + (int) (account_id ^ (account_id >>> 32));

        return result;
    }
    @Override
    public boolean equals(Object obj) {
        Student sobj = (Student) obj;
        if(account_id == sobj.account_id)
        {
            return true;
        }
        return false;
    }

    
    
}
