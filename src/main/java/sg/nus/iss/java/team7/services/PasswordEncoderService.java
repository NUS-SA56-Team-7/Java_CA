package sg.nus.iss.java.team7.services;

import org.springframework.stereotype.Component;

@Component
public interface PasswordEncoderService {
    public String passwordEncoder(String password);

    public boolean passwordAuthentication(String encodedPassword,String password);
    
}
