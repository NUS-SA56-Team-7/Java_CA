package sg.nus.iss.java.team7.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.services.PasswordEncoderService;
@Service
public class PasswordEncoderServiceImpl implements PasswordEncoderService{
    @Autowired 
    private BCryptPasswordEncoder encoder;

    public PasswordEncoderServiceImpl()
    {
        this.encoder = new BCryptPasswordEncoder(-1);
    }
    
    
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