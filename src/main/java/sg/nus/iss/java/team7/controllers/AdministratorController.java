package sg.nus.iss.java.team7.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.iss.java.team7.models.RequestUpdate;
import sg.nus.iss.java.team7.services.RequestUpdateService;

@Controller
@RequestMapping("/administrator")
public class AdministratorController {
    @Autowired
    private RequestUpdateService requestUpdateService;

    @GetMapping("/{administratorId}/allrequests")
    public String getRequestUpdates(@PathVariable Long administratorId, Model model) {
        List<RequestUpdate> requestUpdateList = requestUpdateService.getRequestUpdates();
        model.addAttribute("requestUpdateList", requestUpdateList);
        return "administrator/view-requestupdates";
    }
}
