package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"https://blackjack-tent.onrender.com"})
public class HelloController {

    @Autowired
    private StrategyService strategyService;

    @GetMapping("/leaderboard")
    public List<LeaderboardEntry> getLeaderboard() {
        // Beispielhafte statische Daten
        return List.of(
                new LeaderboardEntry("Alice", 1200),
                new LeaderboardEntry("Bob", 1100),
                new LeaderboardEntry("Charlie", 1050)
        );
    }

    @PostMapping
    public Strategy createStrategy(@RequestBody Strategy strategy) {
        return strategyService.saveStrategy(strategy);
    }
}
