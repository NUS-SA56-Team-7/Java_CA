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
@RequestMapping(path = "/gradeReport")
public class GradeReportController {
    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private GradeService gradeService;

    @GetMapping("/form")
    private ModelAndView selectCourseForm(@ModelAttribute("lecturer_id") String lecturerId, Model model, HttpSession session) {
        List<Course> courses = courseService.findCoursesByLecturerId(lecturerId);
        model.addAttribute("courseList", courses);
        return new ModelAndView("selectCourse");
    }

    @PostMapping("/form")
    private String generateGradeReport(@ModelAttribute("course_id") String courseId, Model model, HttpSession session) {
        List<Student> students = studentService.findStudentsByCourseId(courseId);
        List<Grade> grades = gradeService.findGradesByCourseId(courseId);
        GradeReport gradeReport = new GradeReport();
        gradeReport.setCourseName(courseService.findCourseById(courseId).getName());

        for (Student student : students) {
            GradeInfo gradeInfo = new GradeInfo();
            gradeInfo.setStudentName(student.getName());
            Grade grade = gradeService.findGradeByStudentIdAndCourseId(student.getId(), courseId);
            gradeInfo.setScore(grade.getScore());

            if (grade.getScore() >= 80) {
                gradeInfo.setGrade("A");
            } else if (grade.getScore() >= 50) {
                gradeInfo.setGrade("B");
            } else {
                gradeInfo.setGrade("F");
            }

            gradeReport.addGradeInfo(gradeInfo);
        }

        gradeReport.calculateStatistics();
        model.addAttribute("gradeReport", gradeReport);
        return "gradeReport";
    }
}

