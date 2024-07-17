package com.alura.literalura;

import com.alura.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {
    @Autowired
    private LibroService libroService;

    public static void main(String[] args) {
        SpringApplication.run(LiterAluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Buscar libro por título");
            System.out.println("2. Listar todos los libros");
            System.out.println("3. Listar autores");
            System.out.println("4. Listar autores vivos en un determinado año");
            System.out.println("5. Listar libros por idioma");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el título del libro:");
                    String titulo = scanner.nextLine();
                    libroService.buscarYGuardarLibroPorTitulo(titulo);
                    break;
                case 2:
                    libroService.listarLibros().forEach(System.out::println);
                    break;
                case 3:
                    libroService.listarAutores().forEach(System.out::println);
                    break;
                case 4:
                    System.out.println("Ingrese el año:");
                    int ano = scanner.nextInt();
                    libroService.listarAutoresVivosEnAno(ano).forEach(System.out::println);
                    break;
                case 5:
                    System.out.println("Ingrese el idioma (ES, EN, FR, PT):");
                    String idioma = scanner.nextLine();
                    libroService.listarLibrosPorIdioma(idioma).forEach(System.out::println);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
