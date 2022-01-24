package com.football.football_stats.data_updater.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.util.Pair;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Properties;

abstract class CommonUpdater {
    protected final String jsonParentKey;
    final Properties config;
    private final URI baseUri;

    CommonUpdater(String propertyKey, String jsonParentKey) {
        this.config = ConfigLoaderService.getInstance();
        this.baseUri = getURI(propertyKey);
        this.jsonParentKey = jsonParentKey;
    }

    private URI getURI(String propertyKey) {
        return UriComponentsBuilder.newInstance().scheme(config.getProperty("url_protocol")).host(config.getProperty("base_url")).pathSegment(config.getProperty("version"), config.getProperty("format"), config.getProperty("key"), config.getProperty(propertyKey)).build().toUri();
    }

    public void update() throws IOException, InterruptedException {
        String jsonString = jsonGetter(baseUri);
        JsonNode jsonNode = jsonReader(jsonString);
        writeToDB(jsonNode);
    }
//
//    public void update(String queryParamKey, String queryParamValue) throws IOException, InterruptedException {
//        URI uri = UriComponentsBuilder.fromUri(this.baseUri).query(String.format("%s=%s", config.getProperty(queryParamKey), queryParamValue)).build().toUri();
//        String jsonString = jsonGetter(uri);
//        JsonNode jsonNode = jsonReader(jsonString);
//        writeToDB(jsonNode);
//    }

    public void update(ArrayList<Pair<String, String>> queryParams) throws IOException, InterruptedException {

        UriComponentsBuilder uri = UriComponentsBuilder.fromUri(this.baseUri);
        for (Pair<String, String> queryParam : queryParams) {
            uri = uri.query(String.format("%s=%s", config.getProperty(queryParam.getFirst()), queryParam.getSecond()));
        }
        String jsonString = jsonGetter(uri.build().toUri());
        JsonNode jsonNode = jsonReader(jsonString);
        writeToDB(jsonNode);
    }

    private String jsonGetter(URI uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private JsonNode jsonReader(String jsonResponse) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonParser parser = mapper.getFactory().createParser(jsonResponse);
        JsonNode node = mapper.readTree(parser);
        return node.get(jsonParentKey);
    }

    void writeToDB(JsonNode jsonNode) {
        jsonNode.forEach(this::setProperties);
    }

    abstract void setProperties(JsonNode element);

}