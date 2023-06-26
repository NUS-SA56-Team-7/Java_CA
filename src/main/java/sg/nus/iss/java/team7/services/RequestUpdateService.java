package sg.nus.iss.java.team7.services;

import java.util.List;

import sg.nus.iss.java.team7.models.RequestUpdate;

public interface RequestUpdateService {
    RequestUpdate requestCourseUpdate(RequestUpdate requestUpdate);

    List<RequestUpdate> getRequestUpdates();
}
