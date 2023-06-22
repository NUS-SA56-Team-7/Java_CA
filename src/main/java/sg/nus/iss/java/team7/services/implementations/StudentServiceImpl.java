package sg.nus.iss.java.team7.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.repos.StudentRepository;
import sg.nus.iss.java.team7.services.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudents()
    {
        return (List<Student>) studentRepository.findAll();
    }
    @Override
    public List<Student> findAllByMatricNumber(String MatricNumber){
        return studentRepository.findByMatricNumber(MatricNumber);
    }
    
}
