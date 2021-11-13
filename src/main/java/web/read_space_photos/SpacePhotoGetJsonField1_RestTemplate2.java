package web.read_space_photos;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.client.RestTemplate;

public class SpacePhotoGetJsonField1_RestTemplate2 {

    public static void main(String[] args) {
        String urlString = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";

        new RestTemplate().getForObject(urlString, JsonNode.class)
                .get("photos")
                .forEach(photo -> System.out.println(photo.get("img_src").asText()));
    }
}
