package sg.nus.iss.java.team7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.repos.LecturerRepository;
import sg.nus.iss.java.team7.services.CourseService;
import sg.nus.iss.java.team7.services.LecturerService;

@Controller
@RequestMapping(path = "/lecturer")
public class LecturerController {

    // @Autowired
    // LecturerRepository lecturerRepository;
    // @Autowired
    // CourseService svcCourse;

    @Autowired
	LecturerService svcLecturer;

    @GetMapping(value = "/list")
    public String lecturerList(Model model, Pageable pageable) {
        List<Lecturer> lecturerList = svcLecturer.getAllLecturers(pageable).getContent();
        model.addAttribute("lecturerList", lecturerList);
        model.addAttribute("role", "admin");
        return "lecturer-list";
    }

    @GetMapping("/create")
    public String createLecturer(Model model) {
        model.addAttribute("lecturer", new Lecturer());
        model.addAttribute("action", "create");
        return "lecturer-create";
    }

    @PostMapping("/create")
    public String createLecturer(@ModelAttribute("lecturer") Lecturer lecturer) {
        svcLecturer.createLecturer(lecturer);
        return "redirect:/lecturer/list";
    }
}
