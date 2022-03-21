package com.football.football_stats.common.repository;

import com.football.football_stats.common.entity.Team;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team, Long> {
    List<Team> findAll();

    List<Team> findAllByStrLeague(String competitionName);
}
