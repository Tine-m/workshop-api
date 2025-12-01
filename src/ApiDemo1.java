import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiDemo1 {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        String url = "https://bored-api.appbrewery.com/random";
        //String url = "https://www.boredapi.com/api/activity"; // skift pr. øvelse
        //String url = "https://raw.githubusercontent.com/Tine-m/workshop-api/main/data/activity.json?t=" +
        //     System.currentTimeMillis(); //clear browser cache
        // String url = "https://api.chucknorris.io/jokes/random";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Statuskode: " + response.statusCode());
        System.out.println("Raw JSON response!:");
        System.out.println(response.body());
    }
}
