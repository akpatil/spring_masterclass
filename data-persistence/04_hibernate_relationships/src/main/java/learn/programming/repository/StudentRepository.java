package learn.programming.repository;

import learn.programming.entity.Course;
import learn.programming.entity.Passport;
import learn.programming.entity.Review;
import learn.programming.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Slf4j
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

    public void jpqlGetCoursesWithoutStudents() {
        log.info("Courses without Students using JPQL...");
        TypedQuery<Course> courses = manager
                                        .createQuery("SELECT c FROM Course c WHERE c.students is empty",
                                        Course.class);
        log.info("Courses {}", courses.getResultList());

    }

    public void jpqlJoins() {
        Query query = manager.createQuery("SELECT c, s FROM Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        for(Object[] o: resultList) {
            log.info("\n Courses: {} \n Students: {}", o[0], o[1]);
        }
    }

    public void jpqlLeftJoins() {
        Query query = manager.createQuery("SELECT c, s FROM Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        for(Object[] o: resultList) {
            log.info("\n Courses: {} \n Students: {}", o[0], o[1]);
        }
    }

    public void jpqlCrossJoins() {
        Query query = manager.createQuery("SELECT c, s FROM Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        for(Object[] o: resultList) {
            log.info("\n Courses: {} \n Students: {}", o[0], o[1]);
        }
    }

    public void criteriaBasics() {
        // Use CriteriaBuilder to create CriteriaQuery returning the expected result object
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Course.class);

        // Define roots for tables involved in the query
        Root<Course> courseRoot = query.from(Course.class);

        // Build the TypedQuery using EntityManager and CriteriaQuery
        TypedQuery<Course> tQuery = manager.createQuery(query.select(courseRoot));

        List<Course> courses = tQuery.getResultList();
        log.info("Courses {}", courses);
    }

    public void criteriaLike() {
        // Use CriteriaBuilder to create CriteriaQuery returning the expected result object
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Course.class);

        // Define roots for tables involved in the query
        Root<Course> courseRoot = query.from(Course.class);

        // Define predicates using CriteriaBuilder
        Predicate likeWild = builder.like(courseRoot.get("name"), "%wild%");

        query.where(likeWild);

        // Build the TypedQuery using EntityManager and CriteriaQuery
        TypedQuery<Course> tQuery = manager.createQuery(query.select(courseRoot));

        List<Course> courses = tQuery.getResultList();
        log.info("Courses {}", courses);
    }

    public void criteriaJoin() {
        // Use CriteriaBuilder to create CriteriaQuery returning the expected result object
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Course.class);

        // Define roots for tables involved in the query
        Root<Course> courseRoot = query.from(Course.class);

        // Define predicates using CriteriaBuilder
        courseRoot.join("students");

        // Build the TypedQuery using EntityManager and CriteriaQuery
        TypedQuery<Course> tQuery = manager.createQuery(query.select(courseRoot));
        TypedQuery<Student> tsQuery = manager.createQuery(query.select(courseRoot));

        List<Course> courses = tQuery.getResultList();
        List<Student> students = tsQuery.getResultList();

        log.info("Courses Join {}", courses);
        log.info("Students Join {}", students);
    }
}
