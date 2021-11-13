package web.find_largest_photo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class FindLargestPhoto_RestTemplate {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=10&api_key=DEMO_KEY";

        List<String> photoUrls = restTemplate.getForObject(url, PhotoStorage.class).getPhotos()
                .stream().map(Photo::getImgSrc).collect(toList());

        photoUrls.stream()
                .collect(toMap(identity(), photoUrl -> getPhotoSize(photoUrl, restTemplate)))
                .entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(entry -> System.out.println(entry.getKey() + "\n" + entry.getValue()));
    }

    private static Long getPhotoSize(String photoUrl, RestTemplate restTemplate) {
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(photoUrl, String.class);
        ResponseEntity<String> photo = restTemplate.getForEntity(
                Objects.requireNonNull(responseEntity.getHeaders().getLocation()), String.class);
        return photo.getHeaders().getContentLength();
    }

    @Data
    private static class PhotoStorage {
        List<Photo> photos;
    }

    @Data
    private static class Photo {
        @JsonProperty("img_src")
        private String imgSrc;
    }
}
