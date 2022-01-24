package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.data_updater.entity.League;
import com.football.football_stats.data_updater.entity.Team;
import com.football.football_stats.data_updater.repository.LeagueRepository;
import com.football.football_stats.data_updater.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class TeamUpdaterService extends CommonUpdater {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private LeagueRepository leagueRepository;

    public TeamUpdaterService() {
        super("teams_in_league", "teams");
    }

    void setProperties(JsonNode element) {
        Team team = new Team();
        team.setIdTeam(element.get("idTeam").asInt());
        team.setStrTeam(element.get("strTeam").asText());
        team.setStrTeamShort(element.get("strTeamShort").asText());
        team.setStrLeague(element.get("strLeague").asText());
        team.setStrStadium(element.get("strStadium").asText());
        try {
            teamRepository.save(team);
        } catch (Exception ignored) {
            //If already existing team, do not save in the db
        }
    }


    public void updateAllTeams() {
        Iterable<League> leagues = leagueRepository.findAll();
        leagues.forEach((league) -> {
            try {
                ArrayList<Pair<String, String>> queryParams = new ArrayList<>();
                queryParams.add(Pair.of("league_param", league.getStrLeague()));
                this.update(queryParams);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(2100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}

