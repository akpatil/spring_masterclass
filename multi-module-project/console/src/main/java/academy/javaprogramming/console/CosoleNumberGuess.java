package academy.javaprogramming.console;

import academy.javaprogramming.Game;
import academy.javaprogramming.MessageGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class CosoleNumberGuess  {
    // private static final Logger logger = LoggerFactory.getLogger(CosoleNumberGuess.class);

    @Autowired
    private Game game;

    @Autowired
    private MessageGenerator messageGenerator;

    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("Container ready for use..");

        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess = sc.nextInt();
            sc.nextLine();

            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");
                String playAgain = sc.nextLine().trim();
                if(playAgain.equalsIgnoreCase("n")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
