package learn.programming;

import learn.programming.dao.PersonJdbcDao;
import learn.programming.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@Slf4j
@SpringBootApplication
public class DataPersistanceApplication implements CommandLineRunner {

    @Autowired
    private PersonJdbcDao dao;

    @Override
    public void run(String... args) throws Exception {
        log.info("Persons findAll method called: {}", dao.findAll());
        log.info("Persons findById method called: {}", dao.findById(1003));
        log.info("Persons deleteById method called: {}", dao.deleteById(1005));
        log.info("Persons insert method called {}", dao.insert(
                new Person(1007, "Claire Redfield", "Racoon City", new Date())));
        log.info("Persons findAll method called: {}", dao.findAll());

        log.info("Persons update method called {}", dao.update(
                new Person(1007, "Chris Redfield", "Racoon City", new Date())));
        log.info("Persons findAll method called: {}", dao.findAll());
        log.info("Person findAllByCustomMapper method called: {}", dao.findAllByCustomMapper());
    }

    public static void main(String[] args) {
        SpringApplication.run(DataPersistanceApplication.class, args);
    }
}
