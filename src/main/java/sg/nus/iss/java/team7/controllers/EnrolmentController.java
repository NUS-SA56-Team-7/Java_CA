package sg.nus.iss.java.team7.controllers;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.services.StudentService;

@Controller
@RequestMapping(path = "/enrolment")
public class EnrolmentController {
    @Autowired
    private StudentService studentService;
    
    @GetMapping("/form")
    private String enrolStudentFrom(Model model,HttpSession session)
    {
        if(session.getAttribute("studentlist") == null)
        {
            session.setAttribute("studentlist", new ArrayList<Student>());
        }
        model.addAttribute("studentList", (List<Student>) studentService.findAllStudents());
        model.addAttribute("addStudentList", session.getAttribute("studentlist"));
       return "enrolment";
        
    }

    @PostMapping("/form")
    private String enrolStudent(@ModelAttribute("matric_number") String matric_number,HttpSession session){
        List<Student> students = (List<Student>) session.getAttribute("studentlist");
        Student student = studentService.findAllByMatricNumber(matric_number).get(0);
        students.add(student);
        session.setAttribute("studentlist", students);
        
        return "redirect:/enrolment/form";
    }
    
}
