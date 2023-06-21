package sg.nus.iss.java.team7.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.services.PasswordEncoderService;
@Service
public class PasswordEncoderServiceImpl implements PasswordEncoderService{
    @Autowired 
<<<<<<< HEAD
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(-1);
=======
    private BCryptPasswordEncoder encoder;

    public PasswordEncoderServiceImpl()
    {
        this.encoder = new BCryptPasswordEncoder(-1);
    }
    
    
>>>>>>> 1c04c192cdc1f6706905863620e2f4d587920c81
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