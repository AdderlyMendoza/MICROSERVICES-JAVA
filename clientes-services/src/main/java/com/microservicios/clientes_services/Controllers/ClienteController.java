package com.microservicios.clientes_services.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservicios.clientes_services.Models.ClienteDTO;
import com.microservicios.clientes_services.Services.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{codigoUnico}")
    public ResponseEntity<ClienteDTO> obtenerCliente(@PathVariable String codigoUnico) {
        return ResponseEntity.ok(clienteService.obtenerClienteDecodificado(codigoUnico));
    }
}


