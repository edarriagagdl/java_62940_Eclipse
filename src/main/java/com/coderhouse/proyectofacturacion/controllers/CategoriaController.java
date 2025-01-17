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

import com.coderhouse.proyectofacturacion.services.CategoriaService;
import com.coderhouse.proyectofacturacion.models.Categoria;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
	
	@Autowired 
	private CategoriaService categoriaService;
	
	@GetMapping
	public List<Categoria> getAllCategorias() {
		return categoriaService.getAllCategorias();
	}
	
	@GetMapping ("/{id}")
	public ResponseEntity<Categoria> getCategoriaById(@PathVariable Long id)
	{
		Categoria categoria = categoriaService.getCategoriaById(id).orElseThrow(); 
		return ResponseEntity.ok().body(categoria);
	}
	
	@PostMapping
	public Categoria createCategoria(@RequestBody Categoria categoria)
	{
		return categoriaService.agregarCategoria(categoria);
	}
	
	@PutMapping
	public ResponseEntity<Categoria> actualizarCategoria(@PathVariable Long id, @RequestBody Categoria detallesCategoria)
	{
		Categoria updatedCategoria = categoriaService.actualizarCategoria(id, detallesCategoria); 
		return ResponseEntity.ok(updatedCategoria);
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) { 
		categoriaService.borrarCategoria(id); 
		return ResponseEntity.ok().build();
	}
	
	
	
}
