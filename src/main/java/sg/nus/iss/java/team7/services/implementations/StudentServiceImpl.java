package sg.nus.iss.java.team7.services.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.exceptions.ResourceNotFoundException;
import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.repos.StudentRepository;
import sg.nus.iss.java.team7.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException());
	}
}
