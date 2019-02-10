package academy.javaprogramming.impl;

import academy.javaprogramming.Game;
import academy.javaprogramming.MessageGenerator;
import academy.javaprogramming.service.GameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    public final Game game;
    public final MessageGenerator messageGenerator;

    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    @PostConstruct
    public void init() {
        log.info("number = {}", game.getNumber());
        log.info("main message = {}", messageGenerator.getMainMessage());
    }

    @Override
    public boolean isGameOver() {
        if(game.isGameWon() || game.isGameLost()) {
            return true;
        }
        return false;
    }

    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
