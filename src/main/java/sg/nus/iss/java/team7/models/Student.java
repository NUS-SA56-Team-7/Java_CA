package sg.nus.iss.java.team7.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;






@Entity
@DiscriminatorValue("student")
public class Student extends Account {

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
