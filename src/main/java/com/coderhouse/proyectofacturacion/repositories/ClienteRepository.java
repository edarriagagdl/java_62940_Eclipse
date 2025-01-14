package com.coderhouse.proyectofacturacion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coderhouse.proyectofacturacion.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
