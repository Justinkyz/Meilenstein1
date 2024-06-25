package de.htw.webtech;

import de.htw.webtech.service.GameService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start")
    public void startGame() {
        gameService.startGame();
    }

    @GetMapping("/player")
    public Player getPlayer() {
        return gameService.getPlayer();
    }

    @GetMapping("/dealer")
    public Player getDealer() {
        return gameService.getDealer();
    }

    @PostMapping("/hit")
    public Card hit() {
        return gameService.hit();
    }

    @PostMapping("/stand")
    public void stand() {
        gameService.stand();
    }

    @GetMapping("/result")
    public String getResult() {
        return gameService.getResult();
    }
}
