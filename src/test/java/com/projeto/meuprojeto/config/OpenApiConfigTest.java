package com.projeto.meuprojeto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OpenApiConfigTest {

    @Test
    void customOpenAPI_shouldConfigureApiInfoCorrectly() {
        OpenApiConfig config = new OpenApiConfig();

        OpenAPI openAPI = config.customOpenAPI();

        assertNotNull(openAPI, "OpenAPI instance should not be null");
        Info info = openAPI.getInfo();
        assertNotNull(info, "Info should not be null");
        assertEquals("API de Alunos", info.getTitle());
        assertEquals("Endpoints do projeto DevOps-main", info.getDescription());
        assertEquals("v1", info.getVersion());
    }
}
