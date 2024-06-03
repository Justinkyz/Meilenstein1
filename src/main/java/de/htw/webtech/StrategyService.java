package de.htw.webtech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrategyService {

    @Autowired
    private StrategyRepository strategyRepository;

    public List<Strategy> getAllStrategies() {
        return strategyRepository.findAll();
    }

    public Strategy saveStrategy(Strategy strategy) {
        return strategyRepository.save(strategy);
    }
}
