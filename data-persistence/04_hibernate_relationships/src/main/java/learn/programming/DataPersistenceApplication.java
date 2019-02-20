package learn.programming;

import learn.programming.repository.CourseRepository;
import learn.programming.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

@Slf4j
@SpringBootApplication
public class DataPersistenceApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public static void main(String[] args) {
        SpringApplication.run(DataPersistenceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Spring Application is running...");
        //studentRepository.saveStudentWithPassport();
        //studentRepository.saveReviewsForCourse();
        //studentRepository.jpqlGetCoursesWithoutStudents();
        //studentRepository.jpqlJoins();
        //studentRepository.jpqlLeftJoins();
        //studentRepository.jpqlCrossJoins();
        //studentRepository.criteriaBasics();
        //studentRepository.criteriaLike();
        //studentRepository.criteriaJoin();

        log.info("Course: {}", courseRepository.findById(1L));

        Sort sort = new Sort(Sort.Direction.DESC, "name");
        log.info("All Courses: {}", courseRepository.findAll(sort));
        log.info("Wild Course {}", courseRepository.courseWithWildInIt());
        log.info("Wild Course {}", courseRepository.courseWithWildInItCustom());
        log.info("Named Query called from Jpa Repository {}", courseRepository.allCoursesWithNamedQueries());
    }
}
