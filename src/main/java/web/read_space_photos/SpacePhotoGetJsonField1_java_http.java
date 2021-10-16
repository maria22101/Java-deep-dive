package web.read_space_photos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

/**
 * This class utilizes java.net.http library and jackson for parsing json and getting its field(s) value(s)
 */
public class SpacePhotoGetJsonField1_java_http {

    @SneakyThrows
    public static void main(String[] args) {
        String uriString = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uriString))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(httpRequest, BodyHandlers.ofString());

        getPrintImageLinks(response.body());
    }

    private static void getPrintImageLinks(String json) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode tree = mapper.readTree(json);
        tree.get("photos")
                .forEach(node -> System.out.println(node.get("img_src").asText()));
    }
}
