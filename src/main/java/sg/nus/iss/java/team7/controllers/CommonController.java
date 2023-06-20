package sg.nus.iss.java.team7.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    /**
     * *
     * FOR TESTING PURPOSES ONLY.
     * 
     * @return
     */

    @GetMapping(value = { "/", "/home" })
    public String home() {
        return "login";
    }

    @GetMapping(value = { "/dashboard"})
    public String dashboard(Model model) {
        model.addAttribute("role", "admin");
        return "dashboard";
    }

    @GetMapping(value = { "/student" })
    public String studentList(Model model) {
        model.addAttribute("role", "admin");
        return "student-list";
    }

    @GetMapping(value = { "/student/create" })
    public String studentCreate(Model model) {
        model.addAttribute("role", "admin");
        return "student-create";
    }

    @GetMapping(value = { "/student/update" })
    public String studentUpdate(Model model) {
        model.addAttribute("role", "admin");
        return "student-update";
    }

    @GetMapping(value = { "/errorpage" })
    public String error() {
        return "404";
    }
}
