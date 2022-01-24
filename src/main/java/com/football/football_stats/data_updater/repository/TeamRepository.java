package com.football.football_stats.data_updater.repository;


import com.football.football_stats.data_updater.entity.Team;
import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long> {
}
