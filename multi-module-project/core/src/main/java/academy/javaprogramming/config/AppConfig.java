package academy.javaprogramming.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GameConfig.class)
@ComponentScan(basePackages = "academy.javaprogramming")
public class AppConfig {
    /* As an exercise, we are removing bean dependency and replacing it with
           constructor injection and inline class component mapping */
    /*@Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }*/

    /*@Bean
    public Game game() {
        return new GameImpl();
    }*/

    /*@Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }*/
}
