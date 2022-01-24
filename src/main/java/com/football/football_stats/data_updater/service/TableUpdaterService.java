package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.data_updater.entity.League;
import com.football.football_stats.data_updater.entity.Table;
import com.football.football_stats.data_updater.repository.LeagueRepository;
import com.football.football_stats.data_updater.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;

import java.io.IOException;
import java.util.ArrayList;

public class TableUpdaterService extends CommonUpdater {
    @Autowired
    private TableRepository tableRepository;

    @Autowired
    private LeagueRepository leagueRepository;

    public TableUpdaterService() {
        super("teams_details_in_league_by_id", "table");
    }

    @Override
    void setProperties(JsonNode element) {
        Table table = new Table();
        table.setIdStanding(element.get("idStanding").asInt());
        table.setIntRank(element.get("intRank").asInt());
        table.setIdTeam(element.get("idTeam").asInt());
        table.setStrTeam(element.get("strTeam").asText());
        table.setStrTeamBadge(element.get("strTeamBadge").asText());
        table.setIdLeague(element.get("idLeague").asInt());
        table.setStrLeague(element.get("strLeague").asText());
        table.setStrSeason(element.get("strSeason").asText());
        table.setStrForm(element.get("strForm").asText());
        table.setStrDescription(element.get("strDescription").asText());
        table.setIntPlayed(element.get("intPlayed").asInt());
        table.setIntWin(element.get("intWin").asInt());
        table.setIntLoss(element.get("intLoss").asInt());
        table.setIntDraw(element.get("intDraw").asInt());
        table.setIntGoalsFor(element.get("intGoalsFor").asInt());
        table.setIntGoalsAgainst(element.get("intGoalsAgainst").asInt());
        table.setIntGoalDifference(element.get("intGoalDifference").asInt());
        table.setIntPoints(element.get("intPoints").asInt());
        table.setDateUpdated(element.get("dateUpdated").asText());
        tableRepository.save(table);
    }

    public void updateAllTables() {
        Iterable<League> leagues = leagueRepository.findAll();
        for (String seasons : super.config.getProperty("SEASONS_WHITELIST").toLowerCase()) //TODO Seasons
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
