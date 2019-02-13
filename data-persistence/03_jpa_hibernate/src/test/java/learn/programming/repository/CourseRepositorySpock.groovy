package learn.programming.repository

import learn.programming.DataPersistenceApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@ContextConfiguration(classes = DataPersistenceApplication.class)
class CourseRepositorySpock extends Specification {

    @Autowired
    private CourseRepository courseRepository;

    def "one-item"() {
        given:


        when:
        def course = courseRepository.findById(1001L)

        then:
        course.getName() == "How to be wild"
    }
}
