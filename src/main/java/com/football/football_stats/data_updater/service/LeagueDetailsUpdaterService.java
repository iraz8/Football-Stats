package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.common.entity.League;
import com.football.football_stats.common.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeagueDetailsUpdaterService extends CommonUpdater {
    private final List<String> sportWhitelist;
    private final List<String> leaguesBlacklist;
    private final LeagueRepository leagueRepository;
    private final String idLeagueParam;

    @Autowired
    LeagueDetailsUpdaterService(
            @Value("${api.path.league_details_by_id}") String apiPath,
            @Value("${api.path.league_details_by_id.jsonParentKey}") String jsonParentKey,
            @Value("${api.parameters.league_details_by_id}") String idLeagueParam,
            @Value("#{${whitelist.sport}}") List<String> sportWhitelist,
            @Value("#{${blacklist.leagues}}") List<String> leaguesBlacklist,
            LeagueRepository leagueRepository) {
        super.apiPath = apiPath;
        super.jsonParentKey = jsonParentKey;
        this.sportWhitelist = sportWhitelist;
        this.leaguesBlacklist = leaguesBlacklist;
        this.leagueRepository = leagueRepository;
        this.idLeagueParam = idLeagueParam;
    }

    void setProperties(JsonNode element) {
        if (!sportWhitelist.contains(element.get("strSport").asText())) {
            return;
        }
        if (leaguesBlacklist.contains(element.get("strLeague").asText())) {
            return;
        }
        League league = this.leagueRepository.findLeagueByIdLeague(element.get("idLeague").asInt());
        league.setIntDivision(element.get("intDivision").asInt());
        league.setIdCup(element.get("idCup").asInt());
        league.setStrCurrentSeason(element.get("strCurrentSeason").asText());
        league.setIntFormedYear(element.get("intFormedYear").asInt());
        league.setStrGender(element.get("strGender").asText());
        league.setStrCountry(element.get("strCountry").asText());
        league.setStrWebsite(element.get("strWebsite").asText());
        league.setStrFacebook(element.get("strFacebook").asText());
        league.setStrInstagram(element.get("strInstagram").asText());
        league.setStrTwitter(element.get("strTwitter").asText());
        league.setStrYoutube(element.get("strYoutube").asText());
        league.setStrRSS(element.get("strRSS").asText());
        league.setStrDescriptionEN(element.get("strDescriptionEN").asText());
        league.setStrTvRights(element.get("strTvRights").asText());
        league.setStrBadge(element.get("strBadge").asText());
        league.setStrLogo(element.get("strLogo").asText());
        league.setStrPoster(element.get("strPoster").asText());
        league.setStrTrophy(element.get("strTrophy").asText());
        leagueRepository.save(league);
    }


    public void updateAll() {
        Iterable<League> leagues = leagueRepository.findAll();
        leagues.forEach((league) -> {
            ArrayList<Pair<String, String>> queryParams = new ArrayList<>();
            queryParams.add(Pair.of(idLeagueParam, league.getIdLeague().toString()));
            try {
                this.update(queryParams);
            } catch (NullPointerException ignored) {
            }
        });
    }
}
