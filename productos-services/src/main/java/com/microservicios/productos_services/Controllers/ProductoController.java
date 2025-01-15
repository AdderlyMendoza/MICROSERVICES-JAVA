package com.microservicios.productos_services.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.microservicios.productos_services.Models.ProductoDTO;
import com.microservicios.productos_services.Services.ProductoService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(productoService.obtenerProductosPorCliente(clienteId));
    }
}