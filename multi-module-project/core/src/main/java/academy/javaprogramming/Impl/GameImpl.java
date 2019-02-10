package academy.javaprogramming.Impl;

import academy.javaprogramming.Annotations.GuessCount;
import academy.javaprogramming.Game;
import academy.javaprogramming.NumberGenerator;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {
    // private static final Logger logger = LoggerFactory.getLogger(GameImpl.class);

    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Autowired
    @GuessCount
    private int guessCount;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;

    @PostConstruct
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    @PreDestroy
    public void PreDestroy() {
        log.info("Pre Destroy Called !");
    }

    public void check() {
        checkValidNumberRange();
        if(validNumberRange) {
            if(guess > number) {
                biggest = guess-1;
            }
            if(guess < number) {
                smallest = guess+1;
            }
        }
        remainingGuesses--;
    }

    public boolean isGameWon() {
        return guess == number;
    }

    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
