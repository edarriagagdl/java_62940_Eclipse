package com.coderhouse.proyectofacturacion.services;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.coderhouse.proyectofacturacion.models.Producto;
import com.coderhouse.proyectofacturacion.repositories.ProductoRepository;

import java.util.List; 
import java.util.Optional; 

@Service 
public class ProductoService { 
	
	@Autowired 
	private ProductoRepository productoRepository; 
	
	public List<Producto> getAllProductos() { 
		return productoRepository.findAll(); 
	} 
	
	public Optional<Producto> getProductoById(Long id) { 
	
		return productoRepository.findById(id); 
		
	} 
	
	public Producto agregarProducto(Producto producto) { 
		return productoRepository.save(producto); 
	} 
	
	public Producto actualizarProducto(Long id, Producto productoDetalle) { 
		Producto producto = productoRepository.findById(id).orElseThrow(); 
		producto.setNombre(productoDetalle.getNombre()); 
		producto.setDescripcion(productoDetalle.getDescripcion()); 
		producto.setPrecio(productoDetalle.getPrecio()); 
		return productoRepository.save(producto); 
	} 
	
	public void borrarProducto(Long id) { 
		productoRepository.deleteById(id);
	}
}
