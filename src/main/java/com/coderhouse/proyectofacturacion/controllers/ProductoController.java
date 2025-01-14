package com.coderhouse.proyectofacturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coderhouse.proyectofacturacion.models.Producto;
import com.coderhouse.proyectofacturacion.repositories.ProductoRepository;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}	

	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoById (@PathVariable Long id)
	{
		try {
			if (productoRepository.existsById(id))
			{
				return ResponseEntity.ok(productoRepository.findById(id).get());
			}
			else
			{
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // http 500
		}
		
	}
	
	@PostMapping
	public Producto createProducto(@RequestBody Producto producto)
	{
		return productoRepository.save(producto);
	}
}
