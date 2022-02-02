package com.football.football_stats.common.repository;

import com.football.football_stats.common.entity.Country;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country, Long> {
    List<Country> findAll();
}
