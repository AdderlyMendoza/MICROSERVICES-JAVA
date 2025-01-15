package com.microservicios.productos_services.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long clienteId;
    private String tipoProducto;
    private String nombreProducto;
    private Double saldo;


    // Constructor sin parámetros (requerido por JPA)
    public Producto() {}

    // Constructor con parámetros (para facilitar la creación de instancias)
    public Producto(Long clienteId, String tipoProducto, String nombreProducto, Double saldo) {
        this.clienteId = clienteId;
        this.tipoProducto = tipoProducto;
        this.nombreProducto = nombreProducto;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getClienteId() {
        return clienteId;
    }
    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }
    public String getTipoProducto() {
        return tipoProducto;
    }
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }
    public String getNombreProducto() {
        return nombreProducto;
    }
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    // Getters y Setters
    

}
