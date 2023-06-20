package sg.nus.iss.java.team7.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/enrolment")
public class EnrolmentController {
    @Autowired
    HttpSession context;
    @GetMapping("/test")
    private @ResponseBody String test()
    {
        context.setAttribute("userType", "admin");
        return (String) context.getAttribute("userType");
    }
    
}
