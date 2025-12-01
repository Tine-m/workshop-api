package pokemon;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Indtast Pokémon-navn: ");
        //String name = sc.nextLine().toLowerCase();
        String name = "absol";
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;

        // søg efter pokemon

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        Pokemon p = gson.fromJson(response.body(), Pokemon.class);

        System.out.println("Navn: " + p.name);
        System.out.println("Højde: " + p.height);
        System.out.println("Vægt: " + p.weight);
        System.out.println("Type: " + p.types[0].type.name);
        System.out.println("Sprite URL: " + p.sprites.front_default);

    }
}
