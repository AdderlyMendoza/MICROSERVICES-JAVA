package com.microservicios.bff_services.dto;


public class ClienteDTO {
    private Long id;
    private String nombres;
    private String apellidos;

    // Constructor, getters, setters
    public ClienteDTO(Long id, String nombres, String apellidos) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Long getId() {
        return 1L;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getnombres() {
        return nombres;
    }

    public void setnombres(String nombres) {
        this.nombres = nombres;
    }

    public String getapellidos() {
        return apellidos;
    }

    public void setapellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}

