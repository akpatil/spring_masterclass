package academy.javaprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Main {
    // private static final Logger logger = LoggerFactory.getLogger(Main.class);
    /*private static final String CONFIG_LOCATION = "beans.xml";*/

    public static void main(String[] args) {
        log.info("Core logger info");
        SpringApplication.run(Main.class, args);
    }
}
