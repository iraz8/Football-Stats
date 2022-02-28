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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class ApiController {
    private final CountryRepository countryRepository;
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;
    private final CompetitionTableRepository competitionTableRepository;

    @Autowired
    public ApiController(CountryRepository countryRepository, LeagueRepository leagueRepository, TeamRepository teamRepository, CompetitionTableRepository competitionTableRepository) {
        this.countryRepository = countryRepository;
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
        this.competitionTableRepository = competitionTableRepository;
    }

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
