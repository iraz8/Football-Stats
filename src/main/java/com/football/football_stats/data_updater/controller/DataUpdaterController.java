package com.football.football_stats.data_updater.controller;

import com.football.football_stats.data_updater.service.CountryUpdaterService;
import com.football.football_stats.data_updater.service.LeagueUpdaterService;
import com.football.football_stats.data_updater.service.TeamUpdaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class DataUpdaterController {

    @Autowired
    private LeagueUpdaterService leagueUpdaterService;
    @Autowired
    private CountryUpdaterService countryUpdaterService;
    @Autowired
    private TeamUpdaterService teamUpdaterService;

    @GetMapping("/update/all")
    public String updateAll() {
        try {
            countryUpdaterService.update();
            leagueUpdaterService.update();
            teamUpdaterService.updateAllTeams();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return "Updated all";
    }

    @GetMapping("/update/leagues")
    public String updateLeagues() {
        try {
            leagueUpdaterService.update();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "Leagues updated!";
    }

    @GetMapping("/update/countries")
    public String updateCountries() {
        try {
            countryUpdaterService.update();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "Countries updated!";
    }

    @GetMapping("/update/teams")
    public String updateTeams() {
        teamUpdaterService.updateAllTeams();
        return "Teams updated!";
    }

}
