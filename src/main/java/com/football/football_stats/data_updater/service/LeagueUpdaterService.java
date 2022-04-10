package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.common.entity.League;
import com.football.football_stats.common.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LeagueUpdaterService extends CommonUpdater {
    private final List<String> sportWhitelist;
    private final List<String> leaguesWhitelist;
    private final List<String> leaguesBlacklist;
    private final LeagueRepository leagueRepository;

    @Autowired
    public LeagueUpdaterService(
            @Value("${api.path.leagues}") final String apiPath,
            @Value("${api.path.leagues.jsonParentKey}") final String jsonParentKey,
            @Value("#{${whitelist.sport}}") final List<String> sportWhitelist,
            @Value("#{${whitelist.leagues}}") final List<String> leaguesWhitelist,
            @Value("#{${blacklist.leagues}}") final List<String> leaguesBlacklist,
            final LeagueRepository leagueRepository) {
        super.apiPath = apiPath;
        super.jsonParentKey = jsonParentKey;
        this.sportWhitelist = sportWhitelist;
        this.leaguesWhitelist = leaguesWhitelist;
        this.leaguesBlacklist = leaguesBlacklist;
        this.leagueRepository = leagueRepository;
    }

    void setProperties(final JsonNode element) {
        if (!sportWhitelist.contains(element.get("strSport").asText())) {
            return;
        }
        if (!leaguesWhitelist.contains(element.get("strLeague").asText())) {
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