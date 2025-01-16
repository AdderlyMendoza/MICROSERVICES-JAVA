package com.microservicios.bff_services.dto;

public class ProductoDTO {
    private Long id;
    private String tipo_producto;
    private Double saldo;

    // Constructor, getters, setters
    public ProductoDTO(Long id, String tipo_producto, Double saldo) {
        this.id = id;
        this.tipo_producto = tipo_producto;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettipo_producto() {
        return tipo_producto;
    }

    public void settipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public Double getsaldo() {
        return saldo;
    }

    public void setsaldo(Double saldo) {
        this.saldo = saldo;
    }
}
