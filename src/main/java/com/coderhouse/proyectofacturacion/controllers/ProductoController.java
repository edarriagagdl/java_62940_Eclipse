package com.coderhouse.proyectofacturacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.coderhouse.proyectofacturacion.models.Producto;
import com.coderhouse.proyectofacturacion.services.ProductoService;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping
	public List<Producto> getAllProductos() {
		return productoService.getAllProductos();
	}	

	@GetMapping("/{id}")
	public ResponseEntity<Producto> getProductoById (@PathVariable Long id)
	{
		try {
			
			Producto producto = productoService.getProductoById(id).orElseThrow();
			return ResponseEntity.ok().body(producto);
		} catch (Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // http 500
		}
		
	}
	
	@PostMapping
	public Producto createProducto(@RequestBody Producto producto)
	{
		return productoService.agregarProducto(producto);
	}
	
	@PutMapping("/{id}") 
	public ResponseEntity<Producto> updateProduct(@PathVariable Long id, @RequestBody Producto productoDetalle) 
	{ 
		Producto productoActualizado = productoService.actualizarProducto(id, productoDetalle); 
		return ResponseEntity.ok(productoActualizado); 
	}
	
	@DeleteMapping("/{id}") 
	public ResponseEntity<Void> deleteProducto(@PathVariable Long id) { 
		productoService.borrarProducto(id); 
		return ResponseEntity.noContent().build(); 
	}
}
