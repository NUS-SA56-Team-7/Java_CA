package sg.nus.iss.java.team7.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.nus.iss.java.team7.models.Grading;
import sg.nus.iss.java.team7.repos.GradeRepository;
import sg.nus.iss.java.team7.services.GradeService;
@Service
public class GradeServiceImpl implements GradeService {
    @Autowired
    private GradeRepository gradeRepository;
    @Override
    public List<Grade> findAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade findGradeById(String id) {
        return gradeRepository.findById(id).orElse(null);
    }

    @Override
    public Grade findGradeByStudentIdAndCourseId(String studentId, String courseId) {
        return gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> findGradesByCourseId(String courseId) {
        return gradeRepository.findByCourseId(courseId);
    }

    @Override
    public void saveOrUpdateGrade(Grade grade) {
        gradeRepository.save(grade);
    }

    @Override
    public void deleteGradeById(String id) {
        gradeRepository.deleteById(id);
    }

