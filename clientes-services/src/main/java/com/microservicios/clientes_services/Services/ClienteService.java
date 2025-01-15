package com.microservicios.clientes_services.Services;

import org.springframework.stereotype.Service;

import com.microservicios.clientes_services.Exceptions.ClienteNoEncontradoException;
import com.microservicios.clientes_services.Models.ClienteDTO;
import com.microservicios.clientes_services.Repositories.ClienteRepository;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteDTO obtenerClienteDecodificado(String codigoUnico) {
        String codigoDecodificado = decode(codigoUnico);
        return clienteRepository.findByCodigoUnico(codigoDecodificado)
            .map(cliente -> new ClienteDTO(cliente.getNombres(), cliente.getApellidos(), cliente.getTipoDocumento(), cliente.getNumeroDocumento()))
            .orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado"));
    }

    private String decode(String codigoEncriptado) {
        return "QWxhZGRpbjpPcGVuU2VzYW1l";
    }
}
