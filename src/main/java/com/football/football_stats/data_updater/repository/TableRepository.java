package com.football.football_stats.data_updater.repository;

import com.football.football_stats.data_updater.entity.Table;
import org.springframework.data.repository.CrudRepository;

public interface TableRepository extends CrudRepository<Table, Long> {
}
