package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.data_updater.entity.Country;
import com.football.football_stats.data_updater.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryUpdaterService extends CommonUpdater {
    @Autowired
    private CountryRepository countryRepository;

    public CountryUpdaterService() {
        super("countries", "countries");
    }

    void setProperties(JsonNode element) {
        Country country = new Country();
        country.setName_en(element.get("name_en").asText());
        countryRepository.save(country);
    }
}