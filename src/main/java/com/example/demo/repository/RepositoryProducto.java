package com.example.demo.repository;

import com.example.demo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryProducto extends JpaRepository<Producto, Long> {
}