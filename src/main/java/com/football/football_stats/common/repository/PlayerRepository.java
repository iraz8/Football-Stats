package com.football.football_stats.common.repository;

import com.football.football_stats.common.entity.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findAllbyStrTeam(String strTeam);
}
