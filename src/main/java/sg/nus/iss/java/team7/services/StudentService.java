package sg.nus.iss.java.team7.services;

import java.util.List;


import sg.nus.iss.java.team7.models.Student;
public interface StudentService {

    List<Student> findAllStudents();


    Student findStudentById(String id);


    List<Student> findStudentsByName(String name);


    List<Student> findStudentsByMatricNumber(String matricNumber);


    List<Student> findStudentsByCourseId(String courseId);


    void saveOrUpdateStudent(Student student);


    void deleteStudentById(String id);
}
