package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.football.football_stats.common.entity.Country;
import com.football.football_stats.common.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class CountryUpdaterService extends CommonUpdater {


    private final CountryRepository countryRepository;

    @Autowired
    public CountryUpdaterService(
            @Value("${api.path.countries}") final String apiPath,
            @Value("${api.path.countries.jsonParentKey}") final String jsonParentKey,
            final CountryRepository countryRepository) {
        super.apiPath = apiPath;
        super.jsonParentKey = jsonParentKey;
        this.countryRepository = countryRepository;
    }

    void setProperties(final JsonNode element) {
        Country country = new Country();
        country.setName_en(element.get("name_en").asText());
        countryRepository.save(country);
    }
}
