package com.microservicios.bff_services.Controllers;

import org.springframework.http.HttpStatus;
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
        try {
            System.out.println("CodigoUnico Recibido: " + codigoUnico);

            ClienteDTO cliente = clienteClient.obtenerCliente(codigoUnico);
            System.out.println("Cliente obtenido: " + cliente);

            // System.out.println("Datos del Cliente:");
            // System.out.println("ID: " + cliente.getId());
            // System.out.println("Nombres: " + cliente.getnombres());
            // System.out.println("Apellidos: " + cliente.getapellidos());

            if (cliente == null || cliente.getId() == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(null); // Or create a response body with error message
            }

            List<ProductoDTO> productos = productoClient.obtenerProductosPorCliente(cliente.getId());
            System.out.println("Producto obtenidos: " + productos);

            // Imprimir el nombre de cada producto
            if (productos != null && !productos.isEmpty()) {
                for (ProductoDTO producto : productos) {
                    System.out.println("Tipo del producto: " + producto.gettipoProducto());
                    System.out.println("Saldo del producto: " + producto.getsaldo());
                }
            } else {
                System.out.println("No se encontraron productos para el cliente.");
            }

            System.out.println("----------------------------------------");

            return ResponseEntity.ok(new ClienteProductosDTO(cliente, productos));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Or create an error response body
        }
    }

}
