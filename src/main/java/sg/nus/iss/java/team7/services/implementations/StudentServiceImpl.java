package sg.nus.iss.java.team7.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.repos.StudentRepository;
import sg.nus.iss.java.team7.services.StudentService;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findStudentById(String id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> findStudentsByMatricNumber(String matricNumber) {
        return studentRepository.findByMatricNumber(matricNumber);
    }

    @Override
    public List<Student> findStudentsByCourseId(String courseId) {
        return studentRepository.findByCourseId(courseId);
    }

    @Override
    public void saveOrUpdateStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(String id) {
        studentRepository.deleteById(id);
    }
