package main;

import com.google.gson.Gson;
import model.Title;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reading = new Scanner(System.in);
        System.out.println("Enter a movie to read: ");
        String search = reading.nextLine();
        String address = "http://www.omdbapi.com/?t=" + search + "&apikey=c070c4bb";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();
        System.out.println(json);


        Gson gson = new Gson();
        Title myTitle = gson.fromJson(json, Title.class);
        System.out.println(myTitle);
    }

}
