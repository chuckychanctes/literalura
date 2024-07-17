package com.alura.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GutendexClient {
    private final HttpClient client;

    public GutendexClient() {
        this.client = HttpClient.newHttpClient();
    }

    public String buscarLibroPorTitulo(String titulo) throws Exception {
        String url = "https://gutendex.com/books?search=" + titulo;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
