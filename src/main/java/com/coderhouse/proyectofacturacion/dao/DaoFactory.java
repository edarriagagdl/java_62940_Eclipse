package com.coderhouse.proyectofacturacion.dao;

import com.coderhouse.proyectofacturacion.models.Categoria;
import com.coderhouse.proyectofacturacion.models.Cliente;
import com.coderhouse.proyectofacturacion.models.Producto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class DaoFactory {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persistirProducto (Producto producto)
    {
        em.persist(producto);
    }

    @Transactional
    public void persistirCategoria (Categoria categoria)
    {
        em.persist(categoria);
    }

    @Transactional
    public void persistirCliente (Cliente cliente){
        em.persist(cliente);
    }


}
