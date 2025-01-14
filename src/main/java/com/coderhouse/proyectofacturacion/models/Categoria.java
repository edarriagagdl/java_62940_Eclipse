package com.coderhouse.proyectofacturacion.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="categorias")
public class Categoria {
    private String nombre;
    private String descripcion;
    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (
            name="categoria-producto",
            joinColumns= @JoinColumn (name = "categoria_id"),
            inverseJoinColumns = @JoinColumn (name = "producto_id")
    )
    private List<Producto> productos = new ArrayList<Producto>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="categoria_id")
    private Long id;

    public Categoria() {

    }
    public Categoria(String nombre) {
        this.nombre = nombre;
    }
    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public List<Producto> getProductos() {
        return productos;
    }
    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
