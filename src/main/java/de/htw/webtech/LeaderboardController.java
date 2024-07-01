package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"https://blackjack-tent.onrender.com"})
public class LeaderboardController {

    @Autowired
    private LeaderboardRepository leaderboardRepository;

    @GetMapping("/leaderboard")
    public List<LeaderboardEntry> getLeaderboard() {
        return leaderboardRepository.findAll();
    }

    @PostMapping("/leaderboard")
    public LeaderboardEntry createLeaderboardEntry(@RequestBody LeaderboardEntry entry) {
        return leaderboardRepository.save(entry);
    }
}
