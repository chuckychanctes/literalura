package com.alura.model;

import jakarta.persistence.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int anoNacimiento;
    private int anoFallecimiento;

    // Getters y setters

    // hashCode, equals y toString
}
