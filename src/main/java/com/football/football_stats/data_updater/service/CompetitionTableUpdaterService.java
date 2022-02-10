package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.common.entity.CompetitionTable;
import com.football.football_stats.common.entity.League;
import com.football.football_stats.common.repository.CompetitionTableRepository;
import com.football.football_stats.common.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompetitionTableUpdaterService extends CommonUpdater {
    private final String idLeagueParam;
    private final String seasonParam;
    private final List<String> seasonsWhitelist;

    private final CompetitionTableRepository competitionTableRepository;
    private final LeagueRepository leagueRepository;

    @Autowired
    public CompetitionTableUpdaterService(
            @Value("${api.path.table.byLeagueIdAndSeason}") String apiPath,
            @Value("${api.path.table.byLeagueIdAndSeason.jsonParentKey}") String jsonParentKey,
            @Value("${api.parameters.league.idLeague}") String idLeagueParam,
            @Value("${api.parameters.season}") String seasonParam,
            @Value("#{${whitelist.seasons}}") List<String> seasonsWhitelist,
            CompetitionTableRepository competitionTableRepository, LeagueRepository leagueRepository) {
        super.apiPath = apiPath;
        super.jsonParentKey = jsonParentKey;
        this.seasonsWhitelist = seasonsWhitelist;
        this.seasonParam = seasonParam;
        this.idLeagueParam = idLeagueParam;
        this.competitionTableRepository = competitionTableRepository;
        this.leagueRepository = leagueRepository;
    }

    @Override
    void setProperties(JsonNode element) {
        CompetitionTable competitionTable = new CompetitionTable();
        competitionTable.setIdStanding(element.get("idStanding").asInt());
        competitionTable.setIntRank(element.get("intRank").asInt());
        competitionTable.setIdTeam(element.get("idTeam").asInt());
        competitionTable.setStrTeam(element.get("strTeam").asText());
        competitionTable.setStrTeamBadge(element.get("strTeamBadge").asText());
        competitionTable.setIdLeague(element.get("idLeague").asInt());
        competitionTable.setStrLeague(element.get("strLeague").asText());
        competitionTable.setStrSeason(element.get("strSeason").asText());
        competitionTable.setStrForm(element.get("strForm").asText());
        competitionTable.setStrDescription(element.get("strDescription").asText());
        competitionTable.setIntPlayed(element.get("intPlayed").asInt());
        competitionTable.setIntWin(element.get("intWin").asInt());
        competitionTable.setIntLoss(element.get("intLoss").asInt());
        competitionTable.setIntDraw(element.get("intDraw").asInt());
        competitionTable.setIntGoalsFor(element.get("intGoalsFor").asInt());
        competitionTable.setIntGoalsAgainst(element.get("intGoalsAgainst").asInt());
        competitionTable.setIntGoalDifference(element.get("intGoalDifference").asInt());
        competitionTable.setIntPoints(element.get("intPoints").asInt());
        competitionTable.setDateUpdated(element.get("dateUpdated").asText());
        competitionTableRepository.save(competitionTable);
    }

    public void updateAllTables() {
        competitionTableRepository.deleteAll();
        Iterable<League> leagues = leagueRepository.findAll();
        for (String season : seasonsWhitelist)
            leagues.forEach((league) -> {
                ArrayList<Pair<String, String>> queryParams = new ArrayList<>();
                queryParams.add(Pair.of(idLeagueParam, league.getIdLeague().toString()));
                queryParams.add(Pair.of(seasonParam, season));
                try {
                    this.update(queryParams);
                } catch (NullPointerException ignored) {

                }
                try {
                    Thread.sleep(2100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
    }
}
