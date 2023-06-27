package team7.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import team7.models.Admin;
import team7.models.Course;
import team7.models.Lecturer;
import team7.models.Student;
import team7.models.StudentEnrollment;
import team7.models.UpdateRequest;
import team7.services.AdminService;
import team7.services.CourseService;
import team7.services.EmailService;
import team7.services.LecturerService;
import team7.services.StudentEnrollmentService;
import team7.services.UpdateRequestService;
import team7.validators.CourseValidator;

@Controller
@RequestMapping("/admin/{id}")
public class AdminController {
	
	/*** Dependency Injections ***/
	@Autowired
	AdminService svcAdmin;
	
	@Autowired
	CourseService svcCourse;
	
	@Autowired
	StudentEnrollmentService svcStudentEnrollment;
	
	@Autowired
	UpdateRequestService svcUpdateRequest;
	
	@Autowired
	EmailService svcEmail;
	
	@Autowired
	LecturerService svcLecturer;
	
	@Autowired
	CourseController ctrlCourse;
	
	@Autowired
	LecturerController ctrlLecturer;
	
	@Autowired
	StudentController ctrlStudent;

	/*** Methods ***/
	
	/*** ADMIN ***/
	@GetMapping("")
	public String getAdminDashboard(@PathVariable Long id, Model model) {
		Admin existingAdmin = svcAdmin.getAdminById(id); 
		model.addAttribute("admin", existingAdmin);
		return "dashboard";
	}
	
	/*** COURSE ***/
	@GetMapping("/course")
	public String getAllCourses(Model model) {
		return ctrlCourse.getAllCourses(model);
	}
	
	@GetMapping("/course/create")
	public String getCreateCourse(Model model) {
		return ctrlCourse.getCreateCourse(model);
	}
	
	@PostMapping("/course/create")
	public String postCreateCourse(
			@PathVariable("id") Long adminId,
			@Valid @ModelAttribute("course") Course course,
			BindingResult bindingResult,
			HttpServletRequest request,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			List<Lecturer> lecturers = svcLecturer.getAllLecturers();
			model.addAttribute("lecturerList", lecturers);
			model.addAttribute("action", "create");
			return "course-upsert";
		}
		
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlCourse.postCreateCourse(course, redirectURI);
	}
	
	@GetMapping("/course/update/{courseId}")
	public String getUpdateCourse(@PathVariable Long courseId, Model model) {
		return ctrlCourse.getUpdateCourse(courseId, model);
	}
	
	@PutMapping("/course/update/{courseId}")
	public String putUpdateCourse(
			@PathVariable Long courseId,
			@Valid @ModelAttribute("course") Course course,
			BindingResult bindingResult,
			HttpServletRequest request,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			List<Lecturer> lecturers = svcLecturer.getAllLecturers();
			model.addAttribute("lecturerList", lecturers);
			model.addAttribute("action", "update");
			return "course-upsert";
		}
		
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlCourse.putUpdateCourse(courseId, course, redirectURI);
	}
	
	@GetMapping("/course/delete/{courseId}")
	public String deleteCourse(
			@PathVariable Long courseId,
			HttpServletRequest request) {
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlCourse.deleteCourse(courseId, redirectURI);
	}
	
	@GetMapping("/course/{courseId}/student")
	public String getStudentsByCourse(
			@PathVariable Long courseId,
			Model model) {
		return ctrlCourse.getStudentsInCourse(courseId, model);
	}
	
	@GetMapping("/course/{courseId}/student/{studentId}/{status}")
	public String updateEnrollmentStatusInCourse(
			@PathVariable("id") Long adminId,
			@PathVariable Long courseId,
			@PathVariable Long studentId,
			@PathVariable Integer status) {
		
		String redirectURI = String.format("/admin/%d/enrollment", adminId);
		return this.updateEnrollmentStatus(courseId, studentId, status, redirectURI);
	}
		
	public String updateEnrollmentStatus(
			Long courseId, Long studentId,
			Integer status, String redirectURI) {
		
		svcStudentEnrollment.updateEnrollmentStatus(courseId, studentId, status);
		
		StudentEnrollment enrollment =
				svcStudentEnrollment.getEnrollmentByCourseAndStudent(courseId, studentId);
		Student student = enrollment.getStudent();
		Course course = svcCourse.getDetailedCourse(enrollment.getCourse());
		
		String recipient = enrollment.getStudent().getEmail();
		String subject = "";
		String template = "";
		
		if (status == 1) {			
			subject = String.format("Enrollment Accepted (Course: %s)", course.getCourseName());
			template =
					"Congratulations! " + student.getFirstName() + ' ' + student.getLastName() + ".\n" +
							"Your enrollment for " + course.getCourseName() + " enrolled on " + ' ' + enrollment.getEnrollmentDate() +
							" has been successfully accepted.\n" + 
							"Course Start Date: " + course.getCourseStartDate() + " \n" + 
							"Course End Date: " + course.getCourseEndDate() +
							"Course Duration: " + course.getCourseDuration();
		}
		else if (status == 2) {			
			subject = String.format("Enrollment Rejected (Course: %s)", course.getCourseName());
			template =
					"We are so sorry, " + student.getFirstName() + ' ' + student.getLastName() + ".\n" +
							"Your enrollment for " + course.getCourseName() + " enrolled on " + ' ' + enrollment.getEnrollmentDate() +
							" has been rejected.\n";
		}
		
		svcEmail.sendEmail(recipient, subject, template);
		return String.format("redirect:%s", redirectURI);
	}
	
	
	/*** LECTURER ***/
	@GetMapping("/lecturer")
	public String getAllLecturers(Model model) {
		return ctrlLecturer.getAllLecturers(model);
	}
	
	@GetMapping("/lecturer/create")
	public String getCreateLecturer(Model model) {
		return ctrlLecturer.getCreateLecturer(model);
	}
	
	@PostMapping("/lecturer/create")
	public String postCreateLecturer(
		@Valid @ModelAttribute("lecturer") Lecturer lecturer,
		BindingResult bindingResult,
		HttpServletRequest request,
		Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("action", "create");
			return "lecturer-upsert";
		}
		
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlLecturer.postCreateLecturer(lecturer, redirectURI);
	}
	
	@GetMapping("/lecturer/update/{lecturerId}")
	private String getUpdateLecturer(
			@PathVariable Long lecturerId,
			Model model) {
		return ctrlLecturer.getUpdateLecturer(lecturerId, model);
	}
	
	@PutMapping("/lecturer/update/{lecturerId}")
	private String putUpdateLecturer(
			@PathVariable Long lecturerId,
			@Valid @ModelAttribute("lecturer") Lecturer lecturer,
			BindingResult bindingResult,
			HttpServletRequest request,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("action", "update");
			return "lecturer-upsert";
		}
		
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlLecturer.putUpdateLecturer(lecturerId, lecturer, redirectURI);
	}
	
	@GetMapping("/lecturer/delete/{lecturerId}")
	private String deleteLecturer(
			@PathVariable Long lecturerId,
			HttpServletRequest request) {
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlLecturer.deleteLecturer(lecturerId, redirectURI);
	}
	
	/*** STUDENT ***/
	@GetMapping("/student")
	public String getAllStudents(Model model) {
		return ctrlStudent.getAllStudents(model);
	}
	
	@GetMapping("/student/create")
	public String getCreateStudent(
			Model model) {
		return ctrlStudent.getCreateStudent(model);
	}
	
	@PostMapping("/student/create")
	public String postCreateStudent(
			@Valid @ModelAttribute("student") Student student,
			BindingResult bindingResult,
			HttpServletRequest request,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("action", "create");
			return "student-upsert";
		}
		
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlStudent.postCreateStudent(student, redirectURI);
	}
	
	@GetMapping("/student/update/{studentId}")
	public String getUpdateStudent(
			@PathVariable Long studentId,
			Model model) {
		return ctrlStudent.getUpdateStudent(studentId, model);
	}
	
	@PutMapping("/student/update/{studentId}")
	public String putUpdateStudent(
			@PathVariable Long studentId,
			@Valid @ModelAttribute("student") Student student,
			BindingResult bindingResult,
			HttpServletRequest request,
			Model model) {
		
		if(bindingResult.hasErrors()) {
			model.addAttribute("action", "update");
			return "student-upsert";
		}
		
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlStudent.putUpdateStudent(studentId, student, redirectURI);
	}
	
	@GetMapping("/student/delete/{studentId}")
	public String deleteStudent(
			@PathVariable Long studentId,
			HttpServletRequest request) {
		String URI = request.getRequestURI();
		List<String> splitURI = new ArrayList<String>(Arrays.asList(URI.split("/")));
		splitURI.remove(splitURI.size() - 1);
		splitURI.remove(splitURI.size() - 1);
		String redirectURI = String.join("/", splitURI);
		
		return ctrlStudent.deleteStudent(studentId, redirectURI);
	}
	
	/*** ENROLLMENTS ***/
	@GetMapping("/enrollment")
	public String getAllEnrollments(Model model) {
		List<StudentEnrollment> enrollments = svcStudentEnrollment.getAllEnrollments();
		model.addAttribute("enrollmentList", enrollments);
		return "admin-student-enrollment-list";
	}
	
	/*** UPDATE REQUESTS ***/
	@GetMapping("/request")
	public String getAllUpdateRequests(Model model) {
		List<UpdateRequest> updateRequests = svcUpdateRequest.getAllUpdateRequests();
		model.addAttribute("requestList", updateRequests);
		
		return "admin-update-request-list";
	}
	
	
	@GetMapping("/request/{requestId}/{status}")
	public String getProcessUpdateRequest(
			@PathVariable("id") Long adminId,
			@PathVariable Long requestId,
			@PathVariable Integer status) {
		
		svcUpdateRequest.changeUpdateRequestStatus(requestId, status);
		return String.format("redirect:/admin/%d/request", adminId);
	}
	
}
