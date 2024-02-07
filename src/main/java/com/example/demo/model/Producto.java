package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String modelo;

    @Column
    @Getter
    @Setter
    private int codigo;

    @Column
    @Getter
    @Setter
    private int peso;

    @Column
    @Getter
    @Setter
    private boolean disponible;

    @Column
    @Getter
    @Setter
    private int cantidad;
}
