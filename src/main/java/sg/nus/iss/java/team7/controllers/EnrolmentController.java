package sg.nus.iss.java.team7.controllers;



import java.net.http.HttpResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.resource.HttpResource;

import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.models.StudentEnrolment;
import sg.nus.iss.java.team7.repos.StudentEnrolmentRepository;
import sg.nus.iss.java.team7.services.CourseService;
import sg.nus.iss.java.team7.services.StudentEnrolmentService;
import sg.nus.iss.java.team7.services.StudentService;

@Controller
@RequestMapping(path = "/enrolment")
public class EnrolmentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private StudentEnrolmentService studentEnrolmentService;
    @GetMapping("/form")
    private ModelAndView enrolStudentForm(Model model,HttpSession session)
    {
        if(session.getAttribute("studentlist") == null)
        {
            session.setAttribute("studentlist", new HashMap<Student,String>());
        }
        model.addAttribute("courseList", courseService.findAllCourse());
        model.addAttribute("studentList",  studentService.findAllStudents());
        model.addAttribute("addStudentList", session.getAttribute("studentlist"));
       return new ModelAndView("enrolment");
        
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/form")
    private String enrolStudent(@ModelAttribute("course_name") String course_name,@ModelAttribute("matric_number") String matric_number,HttpSession session){
        HashMap<Student, String> students = (HashMap<Student,String>) session.getAttribute("studentlist");
        Student student = studentService.findAllByMatricNumber(matric_number).get(0);
        if(session.getAttribute("studentenrolment")==null)
        {
            session.setAttribute("studentenrolment", new ArrayList<StudentEnrolment>());
        }
        if(!students.containsKey(student))
        {
            List<StudentEnrolment> studentEnrolment = (List<StudentEnrolment>) session.getAttribute("studentenrolment");
            studentEnrolment.add(new StudentEnrolment(student, courseService.findCourseByName(course_name), null, "enrolled"));
            students.put(student,course_name);
            session.setAttribute("studentenrolment", studentEnrolment);
            
        }
        
        session.setAttribute("studentlist", students);
        
        return "redirect:/enrolment/form";
    }
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping("/submit")
    private String submitStudentEnrolment(@ModelAttribute("date") String date,HttpSession session) throws ParseException{
        
        List<StudentEnrolment> studentEnrolments = (List<StudentEnrolment>) session.getAttribute("studentenrolment");
        SimpleDateFormat localDate = new SimpleDateFormat("dd-MM-yy");
        Date date2 = localDate.parse(date);
        studentEnrolmentService.commitAllStudentEnrolment(studentEnrolments,date2) ;
        session.setAttribute("studentenrolment", null);
        session.setAttribute("studentlist", null);
        
        return "enrolment";
    }
    
}
