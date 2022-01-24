package com.football.football_stats.data_updater.repository;

import com.football.football_stats.data_updater.entity.League;
import org.springframework.data.repository.CrudRepository;

public interface LeagueRepository extends CrudRepository<League, Long> {
}
