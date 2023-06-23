package sg.nus.iss.java.team7.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.CourseStudent;
import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.services.AdministratorService;
import sg.nus.iss.java.team7.services.CourseService;
import sg.nus.iss.java.team7.services.LecturerService;
import sg.nus.iss.java.team7.services.StudentService;

@Controller
@RequestMapping(path = "/course")
public class CourseController {

    // @Autowired
    // private CourseService svcCourse;

    @Autowired
    private LecturerService svcLecturer;

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/list")
    public String getAllCourses(Model model) {
        List<Course> allCourses = courseRepository.findAll();
        model.addAttribute("courseList", allCourses);
        return "course-list";
    }

    @GetMapping("/detail/{id}")
    public String getCourseDetail(@PathVariable("id") Long id, Model model) {
        Course course = courseRepository.findById(id).orElseThrow(null);
        model.addAttribute("course", course);
        return "course-detail";
    }

    // @GetMapping("/courses/create")
    // public String createCourse(Model model, Pageable pageable) {
    // model.addAttribute("course", new Course());
    // List<Lecturer> lecturers =
    // svcLecturer.getAllLecturers(pageable).getContent();
    // model.addAttribute("lecturerList", lecturers);
    // model.addAttribute("action", "create");
    // return "course-upsert";
    // }

    // @PostMapping("/courses/create")
    // public String createCourse(@ModelAttribute("course") Course course) {
    // svcCourse.createCourse(course);
    // return "redirect:/courses";
    // }

    // @GetMapping("/courses/update/{id}")
    // public String updateCourse(@PathVariable Long id, Model model, Pageable
    // pageable) {
    // Course updatingCourse = svcCourse.getCourseById(id);

    // model.addAttribute("course", updatingCourse);
    // List<Lecturer> lecturers =
    // svcLecturer.getAllLecturers(pageable).getContent();
    // model.addAttribute("lecturerList", lecturers);
    // model.addAttribute("action", "update");
    // return "course-upsert";
    // }

    // @PutMapping("/courses/update/{id}")
    // public String updateCourse(@PathVariable Long id, @ModelAttribute("course")
    // Course course) {
    // svcCourse.updateCourse(id, course);
    // return "redirect:/courses";
    // }

    // @GetMapping("/courses/delete/{id}")
    // public String deleteCourse(@PathVariable Long id) {
    // svcCourse.deleteCourse(id);
    // return "redirect:/courses";
    // }

    // @GetMapping("/courses")
    // public String getAllCourses(Model model) {
    // List<Course> allCourses = svcCourse.getAllCourses();
    // model.addAttribute("courseList", allCourses);
    // return "course-list";
    // }

    // @GetMapping("/courses/{id}/students")
    // public String getStudentsByCourse(@PathVariable("id") Long courseId, Model
    // model) {

    // Course existingCourse = svcCourse.getCourseById(courseId);
    // List<Student> studentsByCourse =
    // existingCourse.getCourseStudent().stream()
    // .map(cs -> cs.getStudent()).toList();
    // model.addAttribute("studentList", studentsByCourse);
    // return "student-list";
    // }

    // @GetMapping("/courses/{id}/students/gender")
    // public ResponseEntity<Map<String, List<Student>>>
    // getStudentCountByGenderByCourse(@PathVariable("id") Long courseId, Model
    // model){

    // Course existingCourse = svcCourse.getCourseById(courseId);
    // Map<String, List<Student>> studentsByGender =
    // existingCourse.getCourseStudent().stream()
    // .map(cs ->
    // cs.getStudent()).toList().stream().collect(Collectors.groupingBy(Student::getGender));

    // return new ResponseEntity<Map<String, List<Student>>>(studentsByGender,
    // HttpStatus.OK);
    // // Map<String, List<Person>> personsByGender = persons.stream()
    // // .collect(Collectors.groupingBy(Person::getGender));
    // //
    // // personsByGender.forEach((gender, people) -> {
    // // System.out.println("Gender: " + gender);
    // // people.forEach(System.out::println);
    // // System.out.println();
    // // });
    // }
}
