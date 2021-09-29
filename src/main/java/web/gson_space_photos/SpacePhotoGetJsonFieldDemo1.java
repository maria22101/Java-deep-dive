package web.gson_space_photos;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

public class SpacePhotoGetJsonFieldDemo1 {

    public static void main(String[] args) throws IOException {
        String url = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY";
        JsonReader jsonReader = new JsonReader(new InputStreamReader(new URL(url).openStream()));

        JsonObject rootJsonObject = new Gson().fromJson(jsonReader, JsonObject.class);
        JsonArray photosJsonArray = rootJsonObject.getAsJsonArray("photos");

        for (JsonElement jsonElement : photosJsonArray) {
            System.out.println(jsonElement.getAsJsonObject().get("img_src").getAsString());
        }
    }
}
