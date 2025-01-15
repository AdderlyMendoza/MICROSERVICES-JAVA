package com.microservicios.bff_services.Client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.microservicios.bff_services.dto.ProductoDTO;

import java.util.List;

@Component
public class ProductoClient {
    private final WebClient webClient;
    private final String productosServiceUrl;

    public ProductoClient(WebClient webClient, @Value("${productos-services.url}") String productosServiceUrl) {
        this.webClient = webClient;
        this.productosServiceUrl = productosServiceUrl;
    }

    public List<ProductoDTO> obtenerProductosPorCliente(Long clienteId) {
        try {
            String url = productosServiceUrl + "/productos/cliente/{clienteId}";
            System.out.println("Request URL (ProductoClient): " + url);

            return webClient.get()
                    .uri(url, clienteId)
                    .headers(headers -> headers.setBasicAuth("user", "bf4222df-4140-4f29-aa0a-a50eb07296da"))
                    .retrieve()
                    .bodyToFlux(ProductoDTO.class)
                    .collectList()
                    .block();
        } catch (WebClientResponseException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
            throw new RuntimeException("Error al obtener productos para el cliente", e);
        }
    }
}
