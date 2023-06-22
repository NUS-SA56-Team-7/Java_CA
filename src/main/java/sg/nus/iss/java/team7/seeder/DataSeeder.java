package sg.nus.iss.java.team7.seeder;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sg.nus.iss.java.team7.models.Course;
import sg.nus.iss.java.team7.models.Lecturer;
import sg.nus.iss.java.team7.repos.CourseRepository;
import sg.nus.iss.java.team7.repos.LecturerRepository;

@Component
public class DataSeeder {
    private final LecturerRepository lecturerRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public DataSeeder(LecturerRepository lecturerRepository, CourseRepository courseRepository) {
        this.lecturerRepository = lecturerRepository;
        this.courseRepository = courseRepository;
    }

    @PostConstruct
    public void seedData() {
        List<Lecturer> lecturers = createDummyLecturers();
        // List<Course> courses = createDummyCourses();

        lecturerRepository.saveAll(lecturers);
        // courseRepository.saveAll(courses);
    }

    private List<Lecturer> createDummyLecturers() {
        List<Lecturer> lecturers = new ArrayList<>();

        // Create 10 dummy lecturers
        for (int i = 1; i <= 10; i++) {
            Lecturer lecturer = new Lecturer();
            lecturer.setCreatedAt(OffsetDateTime.now());
            lecturer.setEmail("LecturerEmail" + i + "@gmail.com");
            lecturer.setPassword("lecturer");
            lecturer.setUpdatedAt(OffsetDateTime.now());
            lecturer.setFirstName("Lecturer" + i);
            lecturer.setLastName("LastName" + i);
            lecturer.setTitle("Title" + i);
            lecturer.setCode("Code" + i);
            lecturer.setDesignation("Designation" + i);
            lecturer.setGender("M");
            lecturer.setPhone("123456789" + i);

            lecturers.add(lecturer);
        }

        return lecturers;
    }

    // private List<Course> createDummyCourses() {
    //     List<Course> courses = new ArrayList<>();
    //     List<Lecturer> lecturers = lecturerRepository.findAll();

    //     Random random = new Random();

    //     for (int i = 1; i <= 10; i++) {
    //         Course course = new Course();
    //         course.setCourseName("Course " + i);
    //         course.setDescription("Description for Course " + i);
    //         course.setCourseCredits(random.nextInt());
    //         course.setCourseCapacity(random.nextInt());
    //         course.setCourseFee(random.nextInt());
    //         course.setCourseStartDate(LocalDate.now().plusMonths(i));
    //         course.setCourseDuration(random.nextInt());
    //         course.setCourseStatus(random.nextInt());
    //         course.setLecturer(lecturers.get(1));

    //         courses.add(course);
    //     }

    //     return courses;
    // }
}
