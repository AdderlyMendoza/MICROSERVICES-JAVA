package com.microservicios.productos_services.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservicios.productos_services.Models.ProductoDTO;
import com.microservicios.productos_services.Repository.ProductoRepository;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<ProductoDTO> obtenerProductosPorCliente(Long clienteId) {
        return productoRepository.findByClienteId(clienteId)
            .stream()
            .map(producto -> new ProductoDTO(producto.getTipoProducto(), producto.getNombreProducto(), producto.getSaldo()))
            .toList();
    }
}
