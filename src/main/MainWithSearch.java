package main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Title;
import model.TitleOmdb;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reading = new Scanner(System.in);
        String search = "";
        List<Title> titles = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while(!search.equalsIgnoreCase("exit")) {

            System.out.println("Enter a movie to read: ");
            search = reading.nextLine();

            if(search.equalsIgnoreCase("exit")){
                break;
            }

            String address = "http://www.omdbapi.com/?t=" + search + "&apikey=c070c4bb";
            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String json = response.body();
                System.out.println(json);


                TitleOmdb myTitleOmdb = gson.fromJson(json, TitleOmdb.class);
                System.out.println(myTitleOmdb);

                Title myTitle = new Title(myTitleOmdb);
                System.out.println("////////////////////////////////");
                System.out.println(myTitle);

                titles.add(myTitle);

            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(titles);

        FileWriter writing = new FileWriter("Film.json");
        writing.write(gson.toJson(titles));
        writing.close();

    }

}
