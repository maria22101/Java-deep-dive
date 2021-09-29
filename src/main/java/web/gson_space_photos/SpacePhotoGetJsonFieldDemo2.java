package web.gson_space_photos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Objects;

import org.json.JSONArray;
import org.json.JSONObject;

public class SpacePhotoGetJsonFieldDemo2 {

    public static void main(String[] args) throws IOException {
        String urlString = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
        URL url = new URL(urlString);

        String jsonString = null;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            StringBuilder jsonStringBuilder = new StringBuilder();
            int ch;
            while ((ch = reader.read()) != -1) {
                jsonStringBuilder.append((char) ch);
            }
            jsonString = jsonStringBuilder.toString();
        }
        Objects.nonNull(jsonString);

        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObject.getJSONArray("photos");

        for (int i = 0; i < jsonArray.length(); i++) {
            String img_src = jsonArray.getJSONObject(i).getString("img_src");
            System.out.println(img_src);
        }
    }
}
