package learn.programming;

import learn.programming.jpa.PersonJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class JpaDataPersistenceApplication implements CommandLineRunner {

    @Autowired
    private PersonJpaRepository jpaRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Inside Jpa main implementation");
        log.info("findPersonById method called {}", jpaRepository.findById(1001));
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaDataPersistenceApplication.class, args);
    }
}
