package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;

import java.util.ArrayList;

abstract class CommonUpdater {

    String apiPath;
    String jsonParentKey;


    @Autowired
    JsonParser jsonParser;

    public void update() {
        update(null);
    }

    public void update(ArrayList<Pair<String, String>> queryParams) {
        JsonNode jsonNode = jsonParser.get(jsonParentKey, apiPath, queryParams);
        writeToDB(jsonNode);
    }


    void writeToDB(JsonNode jsonNode) {
        jsonNode.forEach(this::setProperties);
    }

    abstract void setProperties(JsonNode element);

}