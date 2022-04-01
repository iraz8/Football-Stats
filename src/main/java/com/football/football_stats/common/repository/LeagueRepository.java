package com.football.football_stats.common.repository;

import com.football.football_stats.common.entity.League;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LeagueRepository extends CrudRepository<League, Long> {
    List<League> findAll();

    League findLeagueByIdLeague(Integer idLeague);
}
