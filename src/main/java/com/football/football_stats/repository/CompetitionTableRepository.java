package com.football.football_stats.repository;

import com.football.football_stats.entity.CompetitionTable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetitionTableRepository extends CrudRepository<CompetitionTable, Long> {
    List<CompetitionTable> findAll();
}
