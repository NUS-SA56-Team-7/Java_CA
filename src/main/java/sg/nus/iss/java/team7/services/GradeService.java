package sg.nus.iss.java.team7.services;

import java.util.List;


import sg.nus.iss.java.team7.models.Grading;
public interface GradeService {
    //查询所有成绩
    List<Grade> findAllGrades();

    //根据成绩ID查询成绩
    Grade findGradeById(String id);

    //根据学生ID和课程ID查询成绩
    Grade findGradeByStudentIdAndCourseId(String studentId, String courseId);

    //根据课程ID查询成绩列表
    List<Grade> findGradesByCourseId(String courseId);

    //保存或更新成绩
    void saveOrUpdateGrade(Grade grade);

    //删除成绩
    void deleteGradeById(String id);
}


