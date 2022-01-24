package com.football.football_stats.data_updater.repository;

import com.football.football_stats.data_updater.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}
