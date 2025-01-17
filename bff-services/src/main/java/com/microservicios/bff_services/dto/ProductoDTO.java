package com.microservicios.bff_services.dto;

public class ProductoDTO {
    private Long id;
    private String tipoProducto;
    private Double saldo;

    // Constructor, getters, setters
    public ProductoDTO(Long id, String tipoProducto, Double saldo) {
        this.id = id;
        this.tipoProducto = tipoProducto;
        this.saldo = saldo;
    }

    public Long getId() {
        return 1L;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String gettipoProducto() {
        return tipoProducto;
    }

    public void settipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public Double getsaldo() {
        return saldo;
    }

    public void setsaldo(Double saldo) {
        this.saldo = saldo;
    }
}
