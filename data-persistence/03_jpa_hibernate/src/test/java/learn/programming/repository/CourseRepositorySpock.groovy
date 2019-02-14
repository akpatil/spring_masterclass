package learn.programming.repository

import groovy.util.logging.Slf4j
import learn.programming.DataPersistenceApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@Slf4j
@SpringBootTest(classes = DataPersistenceApplication.class)
@ContextConfiguration
class CourseRepositorySpock extends Specification {

    @Autowired
    private CourseRepository courseRepository;

    def findById() {
        given:
        log.info("Inside findById test method")

        when: "Course is fetched by Id"
        def course = courseRepository.findById(1001L)

        then: "Its name should match with the specified name"
        course.getName() == "How to be wild"
    }

    def deleteById() {
        given:
        log.info("Inside deleteById test method")

        when: "Course is deleted by Id"
        courseRepository.deleteById(1002L)

        then: "findById method should return null"
        courseRepository.findById(1002L) == null
    }

    def save() {
        given:
        def course = courseRepository.findById(1L)

        when: "Course name is updated and saved"
        course.name = "Updated course"
        courseRepository.save(course)

        then: "The course gets updated"
        def courseTest = courseRepository.findById(1L)
        courseTest.name == "Updated course"
    }

}
