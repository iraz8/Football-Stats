package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.data_updater.entity.League;
import com.football.football_stats.data_updater.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LeagueUpdaterService extends CommonUpdater {
    @Autowired
    private LeagueRepository leagueRepository;

    public LeagueUpdaterService() {
        super("leagues", "leagues");
    }

    void setProperties(JsonNode element) {
        if (!super.config.getProperty("SPORT_WHITELIST").toLowerCase().contains(element.get("strSport").asText().toLowerCase())) {
            return;
        }
        if (super.config.getProperty("LEAGUES_BLACKLIST").toLowerCase().contains(element.get("strLeague").asText().toLowerCase())) {
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