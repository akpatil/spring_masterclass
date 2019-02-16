package learn.programming;

import learn.programming.entity.Passport;
import learn.programming.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataPersistenceApplication.class)
public class StudentRepositoryTest {
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager manager;

    @Test
    @Transactional
    public void getStudentByIdTest() {
        log.info("Inside Spring Application Test...");
        Student student = manager.find(Student.class, 100L);
        log.info("Student {}", student);
        log.info("Passport {}", student.getPassport());
    }

    @Test
    public void getStudentFromPassport() {
        Passport passport = manager.find(Passport.class, 100L);
        log.info("Passport details {}", passport);
        log.info("Student details {}", passport.getStudent());
    }
}
