package learn.programming;

import learn.programming.entity.FullTimeEmployee;
import learn.programming.entity.PartTimeEmployee;
import learn.programming.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@Slf4j
@SpringBootApplication
public class DataPersistenceApplication implements CommandLineRunner {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Spring application is running...");
        repository.insertEmployee(new FullTimeEmployee("Katakuri", new BigDecimal("11000")));
        repository.insertEmployee(new PartTimeEmployee("Peros Pero", new BigDecimal("6500")));
        log.info("All employees {}", repository.getAllEmployees());
    }

    public static void main(String[] args) {
        SpringApplication.run(DataPersistenceApplication.class, args);
    }
}
