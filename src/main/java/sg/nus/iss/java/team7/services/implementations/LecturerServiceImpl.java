package sg.nus.iss.java.team7.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.repos.LecturerRepository;
import sg.nus.iss.java.team7.services.LecturerService;
@Service
public class LecturerServiceImpl implements LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public List<Lecturer> findAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer findLecturerById(String id) {
        return lecturerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Lecturer> findLecturersByName(String name) {
        return lecturerRepository.findByName(name);
    }

    @Override
    public void saveOrUpdateLecturer(Lecturer lecturer) {
        lecturerRepository.save(lecturer);
    }

    @Override
    public void deleteLecturerById(String id) {
        lecturerRepository.deleteById(id);
    }
}



