package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.data_updater.entity.League;
import com.football.football_stats.data_updater.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeagueUpdaterService extends CommonUpdater {
    private final List<String> sportWhitelist;
    private final List<String> leaguesBlacklist;

    @Autowired
    private LeagueRepository leagueRepository;

    public LeagueUpdaterService(
            @Value("${api.path.leagues}") String apiPath,
            @Value("${api.path.leagues.jsonParentKey}") String jsonParentKey,
            @Value("#{${whitelist.sport}}") List<String> sportWhitelist,
            @Value("#{${blacklist.leagues}}") List<String> leaguesBlacklist
    ) {
        super.apiPath = apiPath;
        super.jsonParentKey = jsonParentKey;
        this.sportWhitelist = sportWhitelist;
        this.leaguesBlacklist = leaguesBlacklist;
    }

    void setProperties(JsonNode element) {
        if (!sportWhitelist.contains(element.get("strSport").asText())) {
            return;
        }
        if (leaguesBlacklist.contains(element.get("strLeague").asText())) {
            return;
        }
        League league = new League();
        league.setIdLeague(element.get("idLeague").asInt());
        league.setStrLeague(element.get("strLeague").asText());
        league.setStrSport(element.get("strSport").asText());
        league.setStrLeagueAlternate(element.get("strLeagueAlternate").asText());
        leagueRepository.save(league);
    }


}