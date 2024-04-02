package com.rahul.publicApi.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.publicApi.entities.Entry;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ApiService {

       final String API_URL = "https://api.publicapis.org/entries";
private final JsonParser parser = new JsonParser();

    public List<Entry> getEntries(String category, Integer entryLimit) throws URISyntaxException, IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().GET().uri(new URI(API_URL)).build();

        var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

        final List<Entry> allEntries = parser.parse(response.body());

        int temp = entryLimit == null ? Integer.MAX_VALUE : entryLimit;

        if(category == null){
            return allEntries.stream().limit(temp).toList();
        }
        return allEntries.stream().filter(entry -> entry.getCategory().equalsIgnoreCase(category)).limit(temp).toList();
    }


private static class JsonParser {
    private final ObjectMapper objectMapper = defaultObjectMapper();

    private ObjectMapper defaultObjectMapper() {
        final ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return objectMapper;
    }

    List<Entry> parse(InputStream inputStream) throws IOException {

        JsonNode jsonNode = objectMapper.readTree(inputStream);
        JsonNode entries = jsonNode.get("entries");
        List<Entry> result = new ArrayList<>();
        Iterator<JsonNode> iterator = entries.elements();

        while(iterator.hasNext()) {
            JsonNode current = iterator.next();
            result.add(objectMapper.treeToValue(current, Entry.class));}
            return result;
    }
}
}
