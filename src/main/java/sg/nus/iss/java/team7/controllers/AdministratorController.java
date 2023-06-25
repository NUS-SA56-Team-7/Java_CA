package sg.nus.iss.java.team7.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.iss.java.team7.services.AdministratorService;
import sg.nus.iss.java.team7.services.RequestUpdateService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    // @Autowired
    // private AdministratorService administratorService;

    // @Autowired
    // private RequestUpdateService requestUpdateService;

    // @GetMapping("/{administratorId}/requests")
    // public String getRequestUpdates(@PathVariable Long administratorId, Model model) {
    //     return "administrator/view-requestupdates";
    // }
}
