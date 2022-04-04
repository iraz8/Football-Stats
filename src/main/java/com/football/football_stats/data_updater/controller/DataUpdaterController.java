package com.football.football_stats.data_updater.controller;

import com.football.football_stats.data_updater.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DataUpdaterController {

    private final LeagueUpdaterService leagueUpdaterService;
    private final LeagueDetailsUpdaterService leagueDetailsUpdaterService;
    private final CountryUpdaterService countryUpdaterService;
    private final TeamUpdaterService teamUpdaterService;
    private final CompetitionTableUpdaterService competitionTableUpdaterService;
    private final PlayerUpdaterService playerUpdaterService;

    @Autowired
    public DataUpdaterController(
            LeagueUpdaterService leagueUpdaterService,
            LeagueDetailsUpdaterService leagueDetailsUpdaterService,
            CountryUpdaterService countryUpdaterService,
            TeamUpdaterService teamUpdaterService,
            CompetitionTableUpdaterService competitionTableUpdaterService,
            PlayerUpdaterService playerUpdaterService) {
        this.leagueUpdaterService = leagueUpdaterService;
        this.leagueDetailsUpdaterService = leagueDetailsUpdaterService;
        this.countryUpdaterService = countryUpdaterService;
        this.teamUpdaterService = teamUpdaterService;
        this.competitionTableUpdaterService = competitionTableUpdaterService;
        this.playerUpdaterService = playerUpdaterService;
    }

    @GetMapping("/update/all")
    public String updateAll() {
        countryUpdaterService.update();
        leagueUpdaterService.update();
        leagueDetailsUpdaterService.updateAll();
        teamUpdaterService.updateAll();
        competitionTableUpdaterService.updateAllTables();
        playerUpdaterService.updateAll();
        return "Updated all";
    }

    @GetMapping("/update/leagues")
    public String updateLeagues() {
        leagueUpdaterService.update();
        leagueDetailsUpdaterService.updateAll();
        return "Leagues updated!";
    }

    @GetMapping("/update/countries")
    public String updateCountries() {
        countryUpdaterService.update();
        return "Countries updated!";
    }

    @GetMapping("/update/teams")
    public String updateTeams() {
        teamUpdaterService.updateAll();
        return "Teams updated!";
    }

    @GetMapping("/update/competition-tables")
    public String updateTables() {
        competitionTableUpdaterService.updateAllTables();
        return "Competition tables updated!";
    }

    @GetMapping("/update/players")
    public String updatePlayers() {
        playerUpdaterService.updateAll();
        return "Players updated!";
    }

}
