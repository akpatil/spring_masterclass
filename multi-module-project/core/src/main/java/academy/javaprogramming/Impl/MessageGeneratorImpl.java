package academy.javaprogramming.Impl;

import academy.javaprogramming.Game;
import academy.javaprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {
    // private static final Logger logger = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    public static final String MAIN_MESSAGE = "game.main.message";
    public static final String WIN = "game.win";
    public static final String LOSE = "game.lose";
    public static final String INVALID_RANGE = "game.invalid.range";
    public static final String FIRST_GUESS = "game.first.guess";
    public static final String HIGHER = "game.higher";
    public static final String LOWER = "game.lower";
    public static final String REMAINING = "game.remaining";

    private final Game game;
    private final MessageSource messageSource;

    @Autowired
    public MessageGeneratorImpl(Game game, MessageSource messageSource) {
        this.game = game;
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void gameValue() {
        log.info("Value of game is {}", game);
    }

    public String getMainMessage() {
        return getMessage(MAIN_MESSAGE, game.getSmallest(), game.getBiggest());
    }

    public String getResultMessage() {
        if(game.isGameWon()) {
            return getMessage(WIN, game.getNumber());
        }
        else if(game.isGameLost()) {
            return getMessage(LOSE, game.getNumber());
        }
        else if(!game.isValidNumberRange()) {
            return getMessage(INVALID_RANGE);
        }
        else if(game.getRemainingGuesses() == game.getGuessCount()) {
            return getMessage(FIRST_GUESS);
        }
        else {
            String direction = getMessage(LOWER);
            if(game.getGuess() < game.getNumber()) {
                direction = getMessage(HIGHER);
            }
            return getMessage(REMAINING, direction, game.getRemainingGuesses());
        }
    }

    private String getMessage(String code, Object ...args) {
        return messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
    }
}
