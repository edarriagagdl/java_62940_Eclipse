package com.coderhouse.proyectofacturacion;

import com.coderhouse.proyectofacturacion.dao.DaoFactory;
import com.coderhouse.proyectofacturacion.models.Categoria;
import com.coderhouse.proyectofacturacion.models.Cliente;
import com.coderhouse.proyectofacturacion.models.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoFacturacionApplication implements CommandLineRunner {

	@Autowired
	private DaoFactory daoFactory;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFacturacionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			Producto producto1 = new Producto("Tenedor", "Tenedor", 10.00, 100);
			Producto producto2 = new Producto("Cuchara", "Cuchara", 12.00, 50);
			Producto producto3 = new Producto("Cuchillo", "Cuchillo", 20.00, 50);

			Categoria categoria1 = new Categoria("Utencilios", "Utencilios de cocina");
			Categoria categoria2 = new Categoria("No pedecederos", "No Pedecederos");

			Cliente cliente1 = new Cliente("Pedro","Jimenez", "111111", "pedro@email.com");
			Cliente cliente2 = new Cliente("Juan","Perez", "22222", "juan@email.com");

			daoFactory.persistirProducto(producto1);
			daoFactory.persistirProducto(producto2);
			daoFactory.persistirProducto(producto3);
			daoFactory.persistirCategoria(categoria1);
			daoFactory.persistirCategoria(categoria2);
			daoFactory.persistirCliente(cliente1);
			daoFactory.persistirCliente(cliente2);



		} catch (Exception e) {
			e.printStackTrace();
		}


	}
}
