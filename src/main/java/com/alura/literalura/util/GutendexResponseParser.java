package com.alura.literalura.util;

import com.alura.model.Autor;
import com.alura.model.Libro;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GutendexResponseParser {
    private final ObjectMapper objectMapper;

    public GutendexResponseParser() {
        this.objectMapper = new ObjectMapper();
    }

    public Libro parsearLibro(String json) throws IOException {
        JsonNode node = objectMapper.readTree(json).path("results").get(0);
        Libro libro = new Libro();
        libro.setTitulo(node.get("title").asText());
        libro.setIdioma(node.get("languages").get(0).asText());
        libro.setNumeroDescargas(node.get("download_count").asInt());

        Autor autor = new Autor();
        JsonNode authorNode = node.get("authors").get(0);
        autor.setNombre(authorNode.get("name").asText());
        autor.setAnoNacimiento(authorNode.get("birth_year").asInt());
        autor.setAnoFallecimiento(authorNode.get("death_year").asInt());
        libro.setAutor(autor);

        return libro;
    }
}
