package com.microservicios.bff_services.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.microservicios.bff_services.dto.ClienteDTO;

@Component
public class ClienteClient {
    private final WebClient webClient;
    private final String clientesServiceUrl;

    public ClienteClient(WebClient webClient, @Value("${clientes-services.url}") String clientesServiceUrl) {
        this.webClient = webClient;
        this.clientesServiceUrl = clientesServiceUrl;
    }

    public ClienteDTO obtenerCliente(String codigoUnico) {
        try {
            String url = clientesServiceUrl + "/clientes/{codigoUnico}";
            System.out.println("Request URL (ClienteClient): " + url);
    
            return webClient.get()
                    .uri(url, codigoUnico)
                    .headers(headers -> headers.setBasicAuth("admin", "admin123"))
                    .retrieve()
                    .bodyToMono(ClienteDTO.class)
                    .block();
        } catch (WebClientResponseException e) {
            System.err.println("Error al obtener cliente: " + e.getMessage());
            throw new RuntimeException("Error al obtener cliente", e);
        }
    }
}
