package com.microservicios.bff_services.dto;

import java.util.List;

public class ClienteProductosDTO {
    private ClienteDTO cliente;
    private List<ProductoDTO> productos;

    public ClienteProductosDTO(ClienteDTO cliente, List<ProductoDTO> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<ProductoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoDTO> productos) {
        this.productos = productos;
    }
}

