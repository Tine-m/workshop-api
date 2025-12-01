import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JokeAPIDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        String url = "https://v2.jokeapi.dev/joke/Any?safe-mode";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Statuskode: " + response.statusCode());
        System.out.println("Raw JSON response!:");
        System.out.println(response.body());

        // Opret Gson-objekt
        Gson gson = new Gson();
        Joke j = gson.fromJson(response.body(), Joke.class);

        if ("single".equals(j.type)) {
            System.out.println("Joke: " + j.joke);
        } else if ("twopart".equals(j.type)) {
            System.out.println("Setup: " + j.setup);
            System.out.println("Punchline: " + j.delivery);
        }

    }
}
