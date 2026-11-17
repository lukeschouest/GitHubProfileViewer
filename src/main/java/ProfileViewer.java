import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ProfileViewer {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a GitHub UserName");
        String userName = input.nextLine().trim();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://api.github.com/users/" + userName))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        int statusCode = response.statusCode();

        if (statusCode == 404) {
            System.out.println("User not found");
            return;
        }

        if(statusCode != 200) {
            System.out.println("Github request failed. " + statusCode);
            return;
        }
        
        String json = response.body();

        JsonObject profile = JsonParser.parseString(json).getAsJsonObject();

        String user = profile.get("login").getAsString();

        int followers = profile.get("followers").getAsInt();

        System.out.println(json);

        System.out.println("Name:" + user);
        System.out.println("Followers: " + followers);
        
    }
}
