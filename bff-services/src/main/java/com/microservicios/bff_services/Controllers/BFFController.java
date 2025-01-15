package com.microservicios.bff_services.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.bff_services.Client.ClienteClient;
import com.microservicios.bff_services.Client.ProductoClient;
import com.microservicios.bff_services.dto.ClienteDTO;
import com.microservicios.bff_services.dto.ClienteProductosDTO;
import com.microservicios.bff_services.dto.ProductoDTO;

import java.util.List;

@RestController
@RequestMapping("/informacion-cliente")
public class BFFController {
    private final ClienteClient clienteClient;
    private final ProductoClient productoClient;

    public BFFController(ClienteClient clienteClient, ProductoClient productoClient) {
        this.clienteClient = clienteClient;
        this.productoClient = productoClient;
    }

    @GetMapping
    public ResponseEntity<ClienteProductosDTO> obtenerInformacionCliente(@RequestParam String codigoUnico) {
        System.out.println("Recibido codigoUnico: " + codigoUnico);

        ClienteDTO cliente = clienteClient.obtenerCliente(codigoUnico);
        System.out.println("Cliente obtenido: " + cliente);

        if (cliente == null || cliente.getId() == null) {
            throw new RuntimeException("Cliente no encontrado o ID es nulo");
        }

        List<ProductoDTO> productos = productoClient.obtenerProductosPorCliente(cliente.getId());
        System.out.println("Productos obtenidos: " + productos);

        return ResponseEntity.ok(new ClienteProductosDTO(cliente, productos));
    }

}
