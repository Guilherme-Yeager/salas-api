package com.githubguilhermeyeager.salasapi.presentation.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomOpenApi {

    @Bean
    public OpenAPI configureOpenAPI() {
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .name("bearerAuth")
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(new Info()
                        .title("API de Reserva de Salas")
                        .version("1.0")
                        .description("Documentação da API para gerenciamento e reserva de salas.")
                        .contact(new Contact()
                                .name("Guilherme Lima Santos")
                                .url("https://github.com/Guilherme-Yeager")
                                .email("guilh2rm2lima@gmail.com")
                        )
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}