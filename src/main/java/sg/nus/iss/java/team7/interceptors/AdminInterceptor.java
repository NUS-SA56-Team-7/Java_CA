package sg.nus.iss.java.team7.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class AdminInterceptor implements HandlerInterceptor{
    @Autowired
    private HttpSession sessionObj;
    @Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response ,Object handler) throws IOException {
        if(sessionObj.getAttribute("userType")==null)
        {
            return true;
        }
        if(!sessionObj.getAttribute("userType").equals("admin"))
        {
            return true;
        }
        if(!request.getRequestURI().contains("enrolment"))
        {
            response.sendError(403);
            
        }
        return true;
    }
}
