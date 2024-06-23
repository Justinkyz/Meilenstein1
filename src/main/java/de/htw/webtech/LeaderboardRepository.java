package de.htw.webtech;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaderboardRepository extends JpaRepository<LeaderboardEntry, Long> {
}
