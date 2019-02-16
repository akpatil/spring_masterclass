package learn.programming;

import learn.programming.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class DataPersistenceApplication implements CommandLineRunner {
    @Autowired
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(DataPersistenceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Spring Application is running...");
        studentRepository.saveStudentWithPassport();
    }
}
