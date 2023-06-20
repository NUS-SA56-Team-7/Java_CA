package sg.nus.iss.java.team7.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import sg.nus.iss.java.team7.interceptors.AdminInterceptor;
@Component
public class WebAppConfig implements WebMvcConfigurer {
    @Autowired
    AdminInterceptor adminInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(adminInterceptor);
    }

}
