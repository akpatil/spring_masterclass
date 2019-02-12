package learn.programming;

import learn.programming.entity.Person;
import learn.programming.jpa.PersonJpaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class JpaDataPersistenceApplication implements CommandLineRunner {

    @Autowired
    private PersonJpaRepository jpaRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Inside Jpa main implementation");
        log.info("findPersonById method called {}", jpaRepository.findById(1001));
        log.info("update method called {}", jpaRepository.update(new Person(1008, "Alicia Mongorell", "Montgomerry", new Date())));
        log.info("update method called {}", jpaRepository.update(new Person(1008, "Alicia Mongorell", "Montgomerry USA", new Date())));
        log.info("findPersonById method called {}", jpaRepository.findById(1008));
        jpaRepository.deleteById(1008);
        log.info("findAll method called {}", jpaRepository.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaDataPersistenceApplication.class, args);
    }
}
