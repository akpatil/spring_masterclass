package academy.javaprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloMaven {
    private static final Logger log = LoggerFactory.getLogger(HelloMaven.class);
    public static void main(String[] args) {
        System.out.println("Hello Maven !");
        log.info("Hello Log !");
        log.debug("Hello Debug !");
    }
}
