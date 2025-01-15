package com.microservicios.productos_services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservicios.productos_services.Models.Producto;
import com.microservicios.productos_services.Repository.ProductoRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadProductos(ProductoRepository productoRepository) {
        return args -> {
            // Usamos el constructor con parámetros
            productoRepository.save(new Producto(1L, "Gaseosa", "Inca Cola", 1234.00));
        };
    }  
}
