package sg.nus.iss.java.team7.services.implementations;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.exceptions.ResourceNotFoundException;
import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.repos.LecturerRepository;
import sg.nus.iss.java.team7.services.LecturerService;

@Service
public class LecturerServiceImpl implements LecturerService {

    @Autowired
    LecturerRepository repoLecturer;

    public Lecturer createLecturer(Lecturer lecturer) {
        lecturer.setCreatedAt(OffsetDateTime.now());
        lecturer.setUpdatedAt(OffsetDateTime.now());

        return repoLecturer.save(lecturer);
    }

    public Page<Lecturer> getAllLecturers(Pageable pageable) {
        return repoLecturer.findAll(pageable);
    }
}
