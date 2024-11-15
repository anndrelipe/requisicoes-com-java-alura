package br.com.alura.exercicios.classes;
import br.com.alura.exercicios.interfaces.Searchable;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest;
import java.net.http.HttpClient;

public class Meal implements Searchable {
    private String name;

    public Meal (String name) {
        this.name = name;
    }

    private String returnFullEndpoint () {
        return "https://www.themealdb.com/api/json/v1/1/search.php?s="+ this.name;
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
