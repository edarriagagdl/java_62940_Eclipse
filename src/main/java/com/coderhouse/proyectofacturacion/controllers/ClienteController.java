package com.coderhouse.proyectofacturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofacturacion.models.Cliente;
import com.coderhouse.proyectofacturacion.repositories.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		if (clienteRepository.existsById(id)) {
			return ResponseEntity.ok(clienteRepository.findById(id).get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Cliente createCliente (@RequestBody Cliente cliente)
	{
		return clienteRepository.save(cliente);	
	}
}
