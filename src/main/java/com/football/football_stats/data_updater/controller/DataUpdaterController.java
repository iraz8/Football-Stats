package com.football.football_stats.data_updater.controller;

import com.football.football_stats.data_updater.service.CompetitionTableUpdaterService;
import com.football.football_stats.data_updater.service.CountryUpdaterService;
import com.football.football_stats.data_updater.service.LeagueUpdaterService;
import com.football.football_stats.data_updater.service.TeamUpdaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataUpdaterController {

    private final LeagueUpdaterService leagueUpdaterService;
    private final CountryUpdaterService countryUpdaterService;
    private final TeamUpdaterService teamUpdaterService;
    private final CompetitionTableUpdaterService competitionTableUpdaterService;

    @Autowired
    public DataUpdaterController(LeagueUpdaterService leagueUpdaterService, CountryUpdaterService countryUpdaterService, TeamUpdaterService teamUpdaterService, CompetitionTableUpdaterService competitionTableUpdaterService) {
        this.leagueUpdaterService = leagueUpdaterService;
        this.countryUpdaterService = countryUpdaterService;
        this.teamUpdaterService = teamUpdaterService;
        this.competitionTableUpdaterService = competitionTableUpdaterService;
    }

    @GetMapping("/update/all")
    public String updateAll() {
        countryUpdaterService.update();
        leagueUpdaterService.update();
        teamUpdaterService.updateAllTeams();
        competitionTableUpdaterService.updateAllTables();
        return "Updated all";
    }

    @GetMapping("/update/leagues")
    public String updateLeagues() {
        leagueUpdaterService.update();
        return "Leagues updated!";
    }

    @GetMapping("/update/countries")
    public String updateCountries() {
        countryUpdaterService.update();
        return "Countries updated!";
    }

    @GetMapping("/update/teams")
    public String updateTeams() {
        teamUpdaterService.updateAllTeams();
        return "Teams updated!";
    }

    @GetMapping("/update/competition-tables")
    public String updateTables() {
        competitionTableUpdaterService.updateAllTables();
        return "Competition tables updated!";
    }

}
