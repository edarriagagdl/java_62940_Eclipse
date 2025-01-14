package com.coderhouse.proyectofacturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.proyectofacturacion.models.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long>{

}
