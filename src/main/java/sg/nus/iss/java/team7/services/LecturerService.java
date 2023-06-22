package sg.nus.iss.java.team7.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.models.Lecturer;

@Service
public interface LecturerService {

	Lecturer createLecturer(Lecturer lecturer);
	
	// Lecturer getLecturerById(Long id);

	// Lecturer getLecturerByEmail(String email);
	
	// Lecturer updateLecturer(Long id, Lecturer lecturer);
	
	// Boolean deleteLecturer(Long id);
	
	Page<Lecturer> getAllLecturers(Pageable pageable);
}
