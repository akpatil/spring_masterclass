package learn.programming;

import learn.programming.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DataPersistenceApplication implements CommandLineRunner {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("findById method called {}", courseRepository.findById(1001L));
    }

    public static void main(String[] args) {
        SpringApplication.run(DataPersistenceApplication.class, args);
    }
}
