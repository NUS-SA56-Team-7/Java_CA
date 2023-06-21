package sg.nus.iss.java.team7.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    @RequestMapping(path="/error",method=RequestMethod.POST)
    public @ResponseBody Map<String, Object> handle(HttpServletRequest request)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("status", request.getAttribute("javax.servlet.error.status_code"));
        map.put("reason",request.getAttribute("javax.servlet.error.message"));
        return map;
    }
}
