package web.read_space_photos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * This class utilizes RestTemplate for parsing json and getting its field(s) value(s)
 */
public class SpacePhotoGetJsonField1_RestTemplate1 {

    public static void main(String[] args) {
        String urlString = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";

        RestTemplate restTemplate = new RestTemplate();
        NasaPhotosResource photos = restTemplate.getForObject(urlString, NasaPhotosResource.class);
        photos.getPhotos()
                .stream()
                .map(photoItem -> photoItem.getImgSrc())
                .forEach(System.out::println);
    }

    @Data
    private static class NasaPhotosResource {
        private List<PhotoItem> photos;
    }

    @Data
    private static class PhotoItem {
        @JsonProperty("img_src")
        private String imgSrc;
    }
}
