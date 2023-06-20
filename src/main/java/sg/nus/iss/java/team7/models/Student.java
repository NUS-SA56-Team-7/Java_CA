package sg.nus.iss.java.team7.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;






@Entity
@DiscriminatorValue("student")
public class Student extends Account {

    public Student(String email, String password, String first_name, String last_name, String phone_number) {
        super(email, password, first_name, last_name, phone_number);
        //TODO Auto-generated constructor stub
    }

    @Override
    public int getAccount_id() {
        // TODO Auto-generated method stub
        return super.getAccount_id();
    }

    @Override
    public void setAccount_id(int account_id) {
        // TODO Auto-generated method stub
        super.setAccount_id(account_id);
    }
    
}
