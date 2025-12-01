import java.net.http.*;
import java.net.URI;
import java.io.IOException;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class ApiDemo2 {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        //String url = "https://bored-api.appbrewery.com/random";
        String url = "https://api.chucknorris.io/jokes/random";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Statuskode: " + response.statusCode());
        System.out.println("Raw JSON response!:");
        System.out.println(response.body());

        //Gson librabry converts JSON to object that Java understands
        System.out.println("\nGson: ");
        JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
        System.out.println("Joke: " + json.get("value").getAsString());
    }
}
