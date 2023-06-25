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
import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.models.RequestUpdate;
import sg.nus.iss.java.team7.models.Student;
import sg.nus.iss.java.team7.services.CourseService;
import sg.nus.iss.java.team7.services.LecturerService;
import sg.nus.iss.java.team7.services.RequestUpdateService;
import sg.nus.iss.java.team7.services.StudentEnrolmentService;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @Autowired
    private CourseService courseService;

    @Autowired
	private StudentEnrolmentService studentEnrolmentService;

	@Autowired
	private RequestUpdateService requestUpdateService;

    @GetMapping("/{lecturerId}/courses")
	public String getTeachingCourses(@PathVariable Long lecturerId, Model model) {
		List<Course> teachingCourses = lecturerService.getTeachingCourses(lecturerId);

		model.addAttribute("lecturerId", lecturerId);
		model.addAttribute("courseList", teachingCourses);
		return "lecturer/teaching-courses";
	}

    @GetMapping("/{lecturerId}/course/{courseId}")
	public String getCourseDetail(@PathVariable Long lecturerId, @PathVariable Long courseId, Model model) {
		Course course = courseService.getCourseById(courseId);
        List<Student> attendingStudents = studentEnrolmentService.attendingStudents(courseId);

		LocalDate today = LocalDate.now();
		LocalDate enrolmentStartDate = course.getCourseStartDate().minusDays(30);
		LocalDate enrolmentEndDate = course.getCourseStartDate().minusDays(10);

		model.addAttribute("lecturerId", lecturerId);
		model.addAttribute("course", course);
        model.addAttribute("studentList", attendingStudents);
		model.addAttribute("today", today);
		model.addAttribute("enrolmentStartDate", enrolmentStartDate);
		model.addAttribute("enrolmentEndDate", enrolmentEndDate);
		return "lecturer/course-detail";
	}

	@GetMapping("/{lecturerId}/course/{courseId}/requestUpdate")
	public String requestUpdate(@PathVariable Long lecturerId, @PathVariable Long courseId, Model model) {
		Lecturer lecturer = lecturerService.getLecturerById(lecturerId);
		Course course = courseService.getCourseById(courseId);
		model.addAttribute("lecturer", lecturer);
		model.addAttribute("course", course);
		model.addAttribute("requestUpdate", new RequestUpdate());
		return "lecturer/request-update";
	}

	@PostMapping("/{lecturerId}/course/{courseId}/requestUpdate")
	public String createRequestUpdate(@PathVariable Long lecturerId, @PathVariable Long courseId, @ModelAttribute("requestUpdate") RequestUpdate requestUpdate) {
		Lecturer lecturer = lecturerService.getLecturerById(lecturerId);
		Course course = courseService.getCourseById(courseId);

		requestUpdate.setLecturer(lecturer);
		requestUpdate.setCourse(course);

		requestUpdateService.requestCourseUpdate(requestUpdate);
		return String.format("redirect:/lecturer/%d/course/%d", lecturerId, courseId);
	}
}
