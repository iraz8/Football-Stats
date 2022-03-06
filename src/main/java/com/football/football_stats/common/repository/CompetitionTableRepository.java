package com.football.football_stats.common.repository;

import com.football.football_stats.common.entity.CompetitionTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetitionTableRepository extends CrudRepository<CompetitionTable, Long> {
    List<CompetitionTable> findAll();

    //    List<CompetitionTable> findAllByStrLeagueOrderByIntRankAsc(String strLeague);
    List<CompetitionTable> findAllByStrLeagueAndStrSeasonOrderByIntRankAsc(String strLeague, String strSeason);
}
