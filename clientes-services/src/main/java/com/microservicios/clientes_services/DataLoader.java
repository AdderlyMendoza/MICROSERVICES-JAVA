package com.microservicios.clientes_services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.microservicios.clientes_services.Models.Cliente;
import com.microservicios.clientes_services.Repositories.ClienteRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ClienteRepository clienteRepository) {
        return args -> {
            Cliente cliente = new Cliente();
            cliente.setNombres("Juan");
            cliente.setApellidos("Pérez");
            cliente.setTipoDocumento("DNI");
            cliente.setNumeroDocumento("12345678");
            cliente.setCodigoUnico("QWxhZGRpbjpPcGVuU2VzYW1l");
            clienteRepository.save(cliente);
        };
    }
}
