package com.coderhouse.proyectofacturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coderhouse.proyectofacturacion.models.Cliente;
import com.coderhouse.proyectofacturacion.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public List<Cliente> getAllClientes() {
		return clienteService.getAllClientes();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) {
		Cliente cliente = clienteService.getClienteById(id).orElseThrow(); 
		return ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping
	public Cliente createCliente (@RequestBody Cliente cliente)
	{
		return clienteService.agregarCliente(cliente);	
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<Cliente> updateCliente(@PathVariable Long id, @RequestBody Cliente detallesCliente) { 
		Cliente updatedCliente = clienteService.actualizarCliente(id, detallesCliente); 
		return ResponseEntity.ok(updatedCliente); 
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> deleteCliente(@PathVariable Long id) { 
		clienteService.borrarCliente(id); 
		return ResponseEntity.noContent().build(); 
	}
}
