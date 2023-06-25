package sg.nus.iss.java.team7.services;

import java.util.List;


import sg.nus.iss.java.team7.models.Lecturer;
public interface LecturerService {

    List<Lecturer> findAllLecturers();


    Lecturer findLecturerById(String id);


    List<Lecturer> findLecturersByName(String name);


    void saveOrUpdateLecturer(Lecturer lecturer);


    void deleteLecturerById(String id);
}


