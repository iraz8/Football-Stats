package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

@Service
class JsonParser {
    private final String apiUrlProtocol;
    private final String apiBaseUrl;
    private final String apiVersion;
    private final String apiFormat;
    private final String apiKey;

    JsonParser(
            @Value("${api.url_protocol}") final String apiUrlProtocol,
            @Value("${api.base_url}") final String apiBaseUrl,
            @Value("${api.version}") final String apiVersion,
            @Value("${api.format}") final String apiFormat,
            @Value("${api.key}") final String apiKey) {
        this.apiUrlProtocol = apiUrlProtocol;
        this.apiBaseUrl = apiBaseUrl;
        this.apiVersion = apiVersion;
        this.apiFormat = apiFormat;
        this.apiKey = apiKey;
    }

    private URI buildURI(final String apiPath, final ArrayList<Pair<String, String>> queryParams) {
        URI uri = UriComponentsBuilder.newInstance().scheme(apiUrlProtocol).host(apiBaseUrl).pathSegment(apiVersion, apiFormat, apiKey, apiPath).build().toUri();

        if (queryParams != null) {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUri(uri);
            for (Pair<String, String> queryParam : queryParams) {
                uriBuilder = uriBuilder.query(String.format("%s=%s", queryParam.getFirst(), queryParam.getSecond()));
            }
            uri = uriBuilder.build().toUri();
        }

        return uri;
    }

    private String getJson(URI uri) {
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
        HttpClient client = HttpClient.newHttpClient();
        String response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    private JsonNode readJson(String jsonResponse, String jsonParentKey) throws java.lang.NullPointerException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = null;
        try {
            com.fasterxml.jackson.core.JsonParser parser = mapper.getFactory().createParser(jsonResponse);
            node = ((JsonNode) mapper.readTree(parser)).get(jsonParentKey);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return node;
    }

    JsonNode get(String jsonParentKey, String apiPath, ArrayList<Pair<String, String>> queryParams) throws NullPointerException {
        URI baseUri = buildURI(apiPath, queryParams);
        String json = getJson(baseUri);
        return readJson(json, jsonParentKey);
    }

}
