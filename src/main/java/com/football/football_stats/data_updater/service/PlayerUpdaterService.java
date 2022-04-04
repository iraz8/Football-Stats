package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.common.entity.Player;
import com.football.football_stats.common.entity.Team;
import com.football.football_stats.common.repository.PlayerRepository;
import com.football.football_stats.common.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PlayerUpdaterService extends CommonUpdater {
    private final TeamRepository teamRepository;
    private final PlayerRepository playerRepository;
    private final String teamParam;

    @Autowired
    public PlayerUpdaterService(
            @Value("${api.path.players_in_team_by_team}") String apiPath,
            @Value("${api.path.players_in_team_by_team.jsonParentKey}") String jsonParentKey,
            @Value("${api.parameters.players_in_team_by_team}") String teamParam,
            TeamRepository teamRepository,
            PlayerRepository playerRepository) {
        super.apiPath = apiPath;
        super.jsonParentKey = jsonParentKey;
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
        this.teamParam = teamParam;
    }

    void setProperties(JsonNode element) {
        Player player = new Player();
        player.setIdPlayer(element.get("idPlayer").asInt());
        player.setIdTeam(element.get("idTeam").asInt());
        player.setIdTeam2(element.get("idTeam2").asInt());
        player.setIdTeamNational(element.get("idTeamNational").asInt());
        player.setStrNationality(element.get("strNationality").asText());
        player.setStrPlayer(element.get("strPlayer").asText());
        player.setStrTeam(element.get("strTeam").asText());
        player.setStrTeam2(element.get("strTeam2").asText());
        player.setStrSport(element.get("strSport").asText());
        player.setDateBorn(element.get("dateBorn").asText());
        player.setStrNumber(element.get("strNumber").asText());
        player.setDateSigned(element.get("dateSigned").asText());
        player.setStrSigning(element.get("strSigning").asText());
        player.setStrWage(element.get("strWage").asText());
        player.setStrBirthLocation(element.get("strBirthLocation").asText());
        player.setStrDescriptionEN(element.get("strDescriptionEN").asText());
        player.setStrGender(element.get("strGender").asText());
        player.setStrSide(element.get("strSide").asText());
        player.setStrPosition(element.get("strPosition").asText());
        player.setStrFacebook(element.get("strFacebook").asText());
        player.setStrWebsite(element.get("strWebsite").asText());
        player.setStrTwitter(element.get("strTwitter").asText());
        player.setStrInstagram(element.get("strInstagram").asText());
        player.setStrYoutube(element.get("strYoutube").asText());
        player.setStrHeight(element.get("strHeight").asText());
        player.setStrWeight(element.get("strWeight").asText());
        player.setIntLoved(element.get("intLoved").asInt());
        player.setStrThumb(element.get("strThumb").asText());
        player.setStrCutout(element.get("strCutout").asText());
        player.setStrRender(element.get("strRender").asText());
        player.setStrBanner(element.get("strBanner").asText());
        playerRepository.save(player);
    }


    public void updateAll() {
        Iterable<Team> teams = teamRepository.findAll();
        teams.forEach((team) -> {
            ArrayList<Pair<String, String>> queryParams = new ArrayList<>();
            queryParams.add(Pair.of(teamParam, team.getStrTeam()));
            try {
                this.update(queryParams);
            } catch (NullPointerException ignored) {
            }
        });

    }
}
