package com.coderhouse.proyectofacturacion.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coderhouse.proyectofacturacion.models.Cliente;
import com.coderhouse.proyectofacturacion.repositories.ClienteRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente actualizarCliente(Long id, Cliente detallesCliente) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNombre(detallesCliente.getNombre());
        cliente.setEmail(detallesCliente.getEmail());
        cliente.setTelefono(detallesCliente.getTelefono());
        return clienteRepository.save(cliente);
    }

    public void borrarCliente(Long id) {
        clienteRepository.deleteById(id);
    }
}
