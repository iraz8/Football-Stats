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
public class JsonParser {
    private final String apiUrl_protocol;
    private final String apiBase_url;
    private final String apiVersion;
    private final String apiFormat;
    private final String apiKey;

    public JsonParser(@Value("${api.url_protocol}") String apiUrl_protocol, @Value("${api.base_url}") String apiBase_url, @Value("${api.version}") String apiVersion, @Value("${api.format}") String apiFormat, @Value("${api.key}") String apiKey) {
        this.apiUrl_protocol = apiUrl_protocol;
        this.apiBase_url = apiBase_url;
        this.apiVersion = apiVersion;
        this.apiFormat = apiFormat;
        this.apiKey = apiKey;
    }

    private URI buildURI(String apiPath, ArrayList<Pair<String, String>> queryParams) {
        URI uri = UriComponentsBuilder.newInstance().scheme(apiUrl_protocol).host(apiBase_url).pathSegment(apiVersion, apiFormat, apiKey, apiPath).build().toUri();

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

    public JsonNode get(String jsonParentKey, String apiPath, ArrayList<Pair<String, String>> queryParams) throws NullPointerException {
        URI baseUri = buildURI(apiPath, queryParams);
        String json = getJson(baseUri);
        return readJson(json, jsonParentKey);
    }

}
