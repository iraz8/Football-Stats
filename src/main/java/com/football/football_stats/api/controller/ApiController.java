package com.football.football_stats.api.controller;

import com.football.football_stats.common.entity.*;
import com.football.football_stats.common.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ApiController {
    private final CountryRepository countryRepository;
    private final LeagueRepository leagueRepository;
    private final TeamRepository teamRepository;
    private final CompetitionTableRepository competitionTableRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public ApiController(
            final CountryRepository countryRepository,
            final LeagueRepository leagueRepository,
            final TeamRepository teamRepository,
            final CompetitionTableRepository competitionTableRepository,
            final PlayerRepository playerRepository) {
        this.countryRepository = countryRepository;
        this.leagueRepository = leagueRepository;
        this.teamRepository = teamRepository;
        this.competitionTableRepository = competitionTableRepository;
        this.playerRepository = playerRepository;
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

    @GetMapping("/api/leagues/{country_name}")
    @ResponseBody
    public List<Team> getAllLeaguesByCountry(@PathVariable final String country_name) {
        return teamRepository.findAllByStrLeague(country_name);
    }


    @GetMapping("/api/table")
    @ResponseBody
    public List<CompetitionTable> getAllLeagues(
            @RequestParam final String competition_name,
            @RequestParam final String season) {
        return competitionTableRepository.findAllByStrLeagueAndStrSeasonOrderByIntRankAsc(competition_name, season);
    }


    @GetMapping("/api/teams/{competition_name}")
    @ResponseBody
    public List<Team> getAllTeamsByCompetition(@PathVariable final String competition_name) {
        return teamRepository.findAllByStrLeague(competition_name);
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


    @GetMapping("/api/players/{team}")
    @ResponseBody
    public List<Player> getAllPlayersByTeam(@PathVariable final String team) {
        return playerRepository.findAllByStrTeam(team);
    }
}
