package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    public GameState startGame() {
        return gameService.startGame();
    }

    @PostMapping("/hit")
    public GameState hit() {
        return gameService.hit();
    }

    @PostMapping("/stand")
    public GameState stand() {
        return gameService.stand();
    }

    @GetMapping("/status")
    public GameState getStatus() {
        return gameService.getGameState();
    }
}
