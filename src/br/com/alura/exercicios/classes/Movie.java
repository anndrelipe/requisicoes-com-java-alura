package br.com.alura.exercicios.classes;

import br.com.alura.exercicios.interfaces.Searchable;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;

public class Movie implements Searchable {
    private String name;
    private String apiKey = "dfe7e4c7";

    public Movie (String name) {
        this.name = name;
    }

    private String returnFullEndpoint () throws UnsupportedEncodingException {
        String encodedName = URLEncoder.encode(this.name, "UTF-8");
        return "https://www.omdbapi.com/?t="+ encodedName + "&apikey=" + this.apiKey;
    }

    @Override
    public void searchForInfos() throws IOException, InterruptedException {
        String url = this.returnFullEndpoint();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                                        .uri(URI.create(url))
                                        .build();
        HttpResponse<String> res = client.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println(res.body());

    }
}
