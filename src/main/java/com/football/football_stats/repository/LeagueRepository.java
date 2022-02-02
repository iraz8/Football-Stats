package com.football.football_stats.repository;

import com.football.football_stats.entity.League;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeagueRepository extends CrudRepository<League, Long> {
    List<League> findAll();
}
