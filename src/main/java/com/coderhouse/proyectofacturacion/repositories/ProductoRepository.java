package com.coderhouse.proyectofacturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.proyectofacturacion.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
