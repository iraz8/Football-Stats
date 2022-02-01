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

    @Autowired
    private LeagueUpdaterService leagueUpdaterService;
    @Autowired
    private CountryUpdaterService countryUpdaterService;
    @Autowired
    private TeamUpdaterService teamUpdaterService;
    @Autowired
    private CompetitionTableUpdaterService competitionTableUpdaterService;

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
