package sg.nus.iss.java.team7.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.models.RequestUpdate;
import sg.nus.iss.java.team7.repos.RequestUpdateRepository;
import sg.nus.iss.java.team7.services.RequestUpdateService;

@Service
public class RequestUpdateServiceImpl implements RequestUpdateService {
    @Autowired
    private RequestUpdateRepository requestUpdateRepository;

    @Override
    public RequestUpdate requestCourseUpdate(RequestUpdate requestUpdate) {
        requestUpdateRepository.saveAndFlush(requestUpdate);
        return requestUpdate;
    }

    @Override
    public List<RequestUpdate> getRequestUpdates() {
        List<RequestUpdate> allRequestUpdate = requestUpdateRepository.findAll();
        return allRequestUpdate;
    }
    
}
