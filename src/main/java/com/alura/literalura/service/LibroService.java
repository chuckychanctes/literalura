package com.alura.literalura.service;

import com.alura.model.Autor;
import com.alura.literalura.model.Libro;
import com.alura.repository.AutorRepository;
import com.alura.literalura.repository.LibroRepository;
import com.alura.literalura.util.GutendexResponseParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private com.alura.service.GutendexClient gutendexClient;

    @Autowired
    private GutendexResponseParser gutendexResponseParser;

    public void buscarYGuardarLibroPorTitulo(String titulo) {
        try {
            String json = gutendexClient.buscarLibroPorTitulo(titulo);
            Libro libro = gutendexResponseParser.parsearLibro(json);
            libroRepository.save(libro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    public List<Autor> listarAutoresVivosEnAno(int ano) {
        return autorRepository.findByAnoNacimientoLessThanEqualAndAnoFallecimientoGreaterThanEqual(ano, ano);
    }

    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }
}
