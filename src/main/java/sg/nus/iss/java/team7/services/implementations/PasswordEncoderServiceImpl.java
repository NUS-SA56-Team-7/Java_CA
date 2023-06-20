package sg.nus.iss.java.team7.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import sg.nus.iss.java.team7.services.PasswordEncoderService;

public class PasswordEncoderServiceImpl implements PasswordEncoderService{
    @Autowired 
    BCryptPasswordEncoder encoder;
    @Override
    public String passwordEncoder(String password)
    {
        return encoder.encode(password);
    }
    
    @Override
    public boolean passwordAuthentication(String encodedPassword,String password) {
        // TODO Auto-generated method stub
        return encoder.matches(encodedPassword, password);
    }
}