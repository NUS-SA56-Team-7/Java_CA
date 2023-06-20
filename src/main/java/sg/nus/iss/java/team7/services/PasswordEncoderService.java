package sg.nus.iss.java.team7.services;


public interface PasswordEncoderService {
    public String passwordEncoder(String password);

    public boolean passwordAuthentication(String encodedPassword,String password);
    
}
