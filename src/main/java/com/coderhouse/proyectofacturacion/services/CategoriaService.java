package com.coderhouse.proyectofacturacion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.proyectofacturacion.models.Categoria;
import com.coderhouse.proyectofacturacion.repositories.CategoriaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> getCategoriaById(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria agregarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria actualizarCategoria(Long id, Categoria detallesCategoria) {
        Categoria categoria = categoriaRepository.findById(id).orElseThrow();
        categoria.setNombre(detallesCategoria.getNombre());
        categoria.setDescripcion(detallesCategoria.getDescripcion());
        return categoriaRepository.save(categoria);
    }

    public void borrarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
