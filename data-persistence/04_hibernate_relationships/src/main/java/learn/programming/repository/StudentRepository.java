package learn.programming.repository;

import learn.programming.entity.Course;
import learn.programming.entity.Passport;
import learn.programming.entity.Review;
import learn.programming.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class StudentRepository {
    @Autowired
    private EntityManager manager;

    public void saveStudentWithPassport() {
        Passport passport = new Passport("W344560");
        manager.persist(passport);

        Student student = new Student("William Birkins");
        student.setPassport(passport);
        manager.persist(student);
    }

    public void saveReviewsForCourse() {
        Course course = manager.find(Course.class, 1L);
        Review r1 = new Review("2", "An ok course");
        Review r2 = new Review("2", "Nothing special");

        course.addReview(r1);
        course.addReview(r2);

        r1.setCourse(course);
        r2.setCourse(course);
        manager.persist(r1);
        manager.persist(r2);
    }
}
