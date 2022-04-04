package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.common.entity.League;
import com.football.football_stats.common.entity.Team;
import com.football.football_stats.common.repository.LeagueRepository;
import com.football.football_stats.common.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeamUpdaterService extends CommonUpdater {
    private final String strLeagueParam;

    private final TeamRepository teamRepository;
    private final LeagueRepository leagueRepository;

    @Autowired
    public TeamUpdaterService(@Value("${api.path.teams_in_league}") String apiPath, @Value("${api.path.teams_in_league.jsonParentKey}") String jsonParentKey, @Value("${api.parameters.league.strLeague}") String strLeagueParam, TeamRepository teamRepository, LeagueRepository leagueRepository) {
        super.apiPath = apiPath;
        super.jsonParentKey = jsonParentKey;
        this.strLeagueParam = strLeagueParam;
        this.teamRepository = teamRepository;
        this.leagueRepository = leagueRepository;
    }

    void setProperties(JsonNode element) {
        Team team = new Team();
        team.setIdTeam(element.get("idTeam").asInt());
        team.setStrTeam(element.get("strTeam").asText());
        team.setIntFormedYear(element.get("intFormedYear").asInt());
        team.setStrTeamShort(element.get("strTeamShort").asText());
        team.setStrLeague(element.get("strLeague").asText());
        team.setStrLeague2(element.get("strLeague2").asText());
        team.setStrLeague3(element.get("strLeague3").asText());
        team.setStrLeague4(element.get("strLeague4").asText());
        team.setStrLeague5(element.get("strLeague5").asText());
        team.setStrLeague6(element.get("strLeague6").asText());
        team.setStrLeague7(element.get("strLeague7").asText());
        team.setStrRss(element.get("strRSS").asText());
        team.setStrStadium(element.get("strStadium").asText());
        team.setStrStadiumThumb(element.get("strStadiumThumb").asText());
        team.setStrStadiumDescription(element.get("strStadiumDescription").asText());
        team.setStrStadiumLocation(element.get("strStadiumLocation").asText());
        team.setIntStadiumCapacity(element.get("intStadiumCapacity").asInt());
        team.setStrWebsite(element.get("strWebsite").asText());
        team.setStrFacebook(element.get("strFacebook").asText());
        team.setStrTwitter(element.get("strTwitter").asText());
        team.setStrInstagram(element.get("strInstagram").asText());
        team.setStrDescriptionEN(element.get("strDescriptionEN").asText());
        team.setStrCountry(element.get("strCountry").asText());
        team.setStrTeamBadge(element.get("strTeamBadge").asText());
        team.setStrTeamJersey(element.get("strTeamJersey").asText());

        try {
            teamRepository.save(team);
        } catch (Exception ignored) {
            //If already existing team, do not save in the db
        }
    }

    public void updateAll() {
        Iterable<League> leagues = leagueRepository.findAll();
        leagues.forEach((league) -> {
            ArrayList<Pair<String, String>> queryParams = new ArrayList<>();
            queryParams.add(Pair.of(strLeagueParam, league.getStrLeague()));
            this.update(queryParams);
        });
    }
}

