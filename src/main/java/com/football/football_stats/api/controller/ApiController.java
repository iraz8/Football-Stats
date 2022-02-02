package com.football.football_stats.api.controller;

import com.football.football_stats.common.entity.CompetitionTable;
import com.football.football_stats.common.entity.Country;
import com.football.football_stats.common.entity.League;
import com.football.football_stats.common.entity.Team;
import com.football.football_stats.common.repository.CompetitionTableRepository;
import com.football.football_stats.common.repository.CountryRepository;
import com.football.football_stats.common.repository.LeagueRepository;
import com.football.football_stats.common.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {
    @Autowired
    CountryRepository countryRepository;

    @Autowired
    LeagueRepository leagueRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    CompetitionTableRepository competitionTableRepository;

    @GetMapping("/api/countries")
    @ResponseBody
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/api/leagues")
    @ResponseBody
    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    @GetMapping("/api/teams")
    @ResponseBody
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/api/competition-tables")
    @ResponseBody
    public List<CompetitionTable> getAllCompetitionTables() {
        return competitionTableRepository.findAll();
    }
}
