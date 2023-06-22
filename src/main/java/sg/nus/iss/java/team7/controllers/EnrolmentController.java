package sg.nus.iss.java.team7.controllers;

import java.util.List;

import javax.crypto.SealedObject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.repos.StudentRepository;
import sg.nus.iss.java.team7.services.StudentService;
import sg.nus.iss.java.team7.services.implementations.StudentServiceImpl;

@Controller
@RequestMapping(path = "/enrolment")
public class EnrolmentController {
    @Autowired
    private StudentService studentService = new StudentServiceImpl();
    @GetMapping("/test")
    private @ResponseBody List<Long> test()
    {
       
        
    }
    
}
