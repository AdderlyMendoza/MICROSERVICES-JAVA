package com.microservicios.clientes_services.Exceptions;

public class ClienteNoEncontradoException extends RuntimeException {
    public ClienteNoEncontradoException(String message) {
        super(message);
    }
    
    public ClienteNoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }
}
