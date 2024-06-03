package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/strategies")
public class HelloController {

    @Autowired
    private StrategyService strategyService;

    @GetMapping
    public List<Strategy> getAllStrategies() {
        return strategyService.getAllStrategies();
    }

    @PostMapping
    public Strategy createStrategy(@RequestBody Strategy strategy) {
        return strategyService.saveStrategy(strategy);
    }
}
