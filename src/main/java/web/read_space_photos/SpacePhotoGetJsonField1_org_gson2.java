package web.read_space_photos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * This class utilizes org.json library for parsing json and getting its field(s) value(s)
 * and by opening connection on url
 */

public class SpacePhotoGetJsonField1_org_gson2 {

    public static void main(String[] args) throws IOException {

        String urlString = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
        URL url = new URL(urlString);
        URLConnection connection = url.openConnection();

        StringBuilder stringBuilder = new StringBuilder();

        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));) {
            String line = bufferedReader.readLine();
            while (Objects.nonNull(line)) {
                stringBuilder.append(line);
                line = bufferedReader.readLine();
            }
        }

        JSONObject jsonObject = new JSONObject(stringBuilder.toString());
        JSONArray arrayOfPhotos = jsonObject.getJSONArray("photos");

        for (int i = 0; i < arrayOfPhotos.length(); i++) {
            System.out.println(arrayOfPhotos.getJSONObject(i).getString("img_src"));
        }
    }
}
