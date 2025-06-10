package com.recipesapi.infrastructure.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Sugestão de Receitas com Gemini AI")
                        .version("1.0.0")
                        .description("Endpoints para sugerir receitas com base em ingredientes cadastrados no banco de dados usando Google Gemini AI.")
                );
    }
}