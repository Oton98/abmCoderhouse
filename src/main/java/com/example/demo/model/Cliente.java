package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String nombre;

    @Column
    @Getter
    @Setter
    private String apellido;

    @Column
    @Getter
    @Setter
    private int dni;

    @Column
    @Getter
    @Setter
    private String correo;
}
