package web.find_largest_photo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.Socket;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.stream.StreamSupport;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FindLargestPhotoAndPost_SocketsAndJackson {
    private static final String NASA_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=12&api_key=DEMO_KEY";
    private static final String BOBOCODE_SERVER_URL = "https://bobocode.herokuapp.com/nasa/pictures";

    public static void main(String[] args) throws IOException {
        postPhotoDataToBobocode(getMaxSizePhotoData());
    }

    private static Map.Entry<String, Integer> getMaxSizePhotoData() throws IOException {
        var photos = new ObjectMapper()
                .readValue(new URL(NASA_URL), JsonNode.class).get("photos");
        return StreamSupport.stream(photos.spliterator(), false)
                .map(photo -> photo.get("img_src").asText())
                .map(photoUrl -> Map.entry(photoUrl, getPhotoSize(photoUrl)))
                .max(Map.Entry.comparingByValue())
                .orElseThrow();
    }

    private static int getPhotoSize(String photoUrl) {
        var photoLocation = getHeaderValue(photoUrl, "Location");
        var photoSize = getHeaderValue(photoLocation, "Content-Length");
        return Integer.parseInt(photoSize);
    }

    @SneakyThrows
    private static String getHeaderValue(String url, String header) {
        var uri = URI.create(url);
        try (var socket = new Socket(uri.getHost(), 80);
             var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()))) {
            writer.println("HEAD " + uri.getPath() + " HTTP/1.1");
            writer.println("Host: " + uri.getHost() + ":80");
            writer.println();
            writer.flush();
            return reader.lines()
                    .filter(l -> l.startsWith(header))
                    .map(s -> s.split(" ")[1].trim())
                    .findAny().orElseThrow();
        }
    }

    @SneakyThrows
    private static void postPhotoDataToBobocode(Map.Entry<String, Integer> maxSizePhotoData) {
        var uri = URI.create(BOBOCODE_SERVER_URL);
        try (var socket = SSLSocketFactory.getDefault().createSocket(uri.getHost(), 443);
             var reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             var writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), UTF_8))) {

            var jsonString = createJsonWithMaxPhotoData(maxSizePhotoData);

            writer.println("POST " + uri.getPath() + " HTTP/1.1");
            writer.println("Host: " + uri.getHost());
            writer.println("Content-Type: application/json;charset=UTF-8");
            writer.println("Content-Length: " + jsonString.length());
            writer.println();
            writer.println(jsonString);
            writer.flush();
            reader.lines().forEach(System.out::println);
        }
    }

    @SneakyThrows
    private static String createJsonWithMaxPhotoData(Map.Entry<String, Integer> maxSizePhotoData) {
        var objectMapper = new ObjectMapper();

        var pictureChildNode = objectMapper.createObjectNode();
        pictureChildNode.put("url", maxSizePhotoData.getKey());
        pictureChildNode.put("size", maxSizePhotoData.getValue());

        var userChildNode = objectMapper.createObjectNode();
        userChildNode.put("firstName", "Mari");
        userChildNode.put("lastName", "Bilous");

        var parentNode = objectMapper.createObjectNode();
        parentNode.set("picture", pictureChildNode);
        parentNode.set("user", userChildNode);

        return objectMapper.writeValueAsString(parentNode);
    }
}
