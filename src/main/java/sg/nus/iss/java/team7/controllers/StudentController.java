package sg.nus.iss.java.team7.controllers;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.models.StudentEnrolment;
import sg.nus.iss.java.team7.services.CourseService;
import sg.nus.iss.java.team7.services.StudentEnrolmentService;
import sg.nus.iss.java.team7.services.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private CourseService courseService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentEnrolmentService studentEnrolmentService;

	@GetMapping("/{studentId}/courses")
	public String getAvailableCourses(@PathVariable Long studentId, Model model) {
		List<Course> availableCourses = courseService.getAvailableCourses(studentId);

		model.addAttribute("studentId", studentId);
		model.addAttribute("courseList", availableCourses);
		return "student/available-courses";
	}

	@GetMapping("/{studentId}/course/{courseId}")
	public String getCourseDetail(@PathVariable Long studentId, @PathVariable Long courseId, Model model) {
		Course course = courseService.getCourseById(courseId);
		String lecturerName = course.getLecturer().getLecturerFirstName() + " " + course.getLecturer().getLecturerLastName();

		LocalDate today = LocalDate.now();
		LocalDate enrolmentStartDate = course.getCourseStartDate().minusDays(30);
		LocalDate enrolmentEndDate = course.getCourseStartDate().minusDays(10);

		model.addAttribute("studentId", studentId);
		model.addAttribute("course", course);
		model.addAttribute("lecturerName", lecturerName);
		model.addAttribute("today", today);
		model.addAttribute("enrolmentStartDate", enrolmentStartDate);
		model.addAttribute("enrolmentEndDate", enrolmentEndDate);
		model.addAttribute("enrolment", new StudentEnrolment());
		return "student/course-detail";
	}

	@PostMapping("/{studentId}/course/{courseId}")
	public String enrolCourse(@PathVariable Long studentId, @PathVariable Long courseId, @ModelAttribute("enrolment") StudentEnrolment enrolment) {
		Student student = studentService.getStudentById(studentId);
		Course course = courseService.getCourseById(courseId);

		enrolment.setStudent(student);
		enrolment.setCourse(course);

		studentEnrolmentService.createStudentEnrolment(enrolment);
		return String.format("redirect:/student/%d/attending", studentId, courseId);
	}

	@GetMapping("/{studentId}/attending")
	public String getAttendingCourses(@PathVariable Long studentId, Model model) {
		List<Course> attendingCourses = courseService.getAttendingCourses(studentId);

		model.addAttribute("studentId", studentId);
		model.addAttribute("courseList", attendingCourses);
		return "student/attending-courses";
	}
}
