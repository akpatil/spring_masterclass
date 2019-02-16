package learn.programming.repository;

import learn.programming.DataPersistenceApplication;
import learn.programming.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DataPersistenceApplication.class)
public class JpqlRepositoryTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EntityManager manager;

    @Test
    public void getCoursesBasicTest() {
        // List resultList = manager.createQuery("Select c From Course c").getResultList();
        List resultList = manager.createNamedQuery("query_to_get_all_courses").getResultList();
        log.info("Courses List {}", resultList);
        log.info("-- The end --");
    }

    @Test
    public void getCoursesTypedTest() {
        TypedQuery<Course> typedQuery = manager.createQuery("Select c From Course c", Course.class);
        List resultList = typedQuery.getResultList();
        log.info("Courses List {}", resultList);
        log.info("-- The end --");
    }
}
