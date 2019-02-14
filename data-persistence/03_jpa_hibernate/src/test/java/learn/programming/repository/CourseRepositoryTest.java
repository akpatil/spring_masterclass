package learn.programming.repository;

import learn.programming.DataPersistenceApplication;
import learn.programming.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

/* SpringRunner is used to launch the entire Spring context demo application */
/* SpringBootTest can also be used to launch specific classes */
/* @SpringBootTest(classes=DataPersistenceApplication.class) */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataPersistenceApplication.class)
public class CourseRepositoryTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void findById() {
        log.info("Test is running...");
        Course course = courseRepository.findById(1001L);
        assertEquals("How to be wild", course.getName());
    }

    /* @DirtiesContext restores data after the test has been executed */

    @Test
    @DirtiesContext
    public void deleteById() {
        courseRepository.deleteById(1001L);
        assertNull(courseRepository.findById(1001L));
    }

    @Test
    @DirtiesContext
    public void save() {
        Course course = courseRepository.findById(1L);
        course.setName("Updated Course to I don't care anymore syllabus");
        courseRepository.save(course);

        Course courseTest = courseRepository.findById(1L);
        assertEquals(courseTest.getName(), "Updated Course to I don't care anymore syllabus");
    }
}
