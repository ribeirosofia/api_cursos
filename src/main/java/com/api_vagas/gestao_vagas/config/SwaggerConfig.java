package com.api_vagas.gestao_vagas.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "Gestão de Vagas",
                description = "API Responsável pela gestão de vagas",
                version = "1"
        ),
        security = {
                @SecurityRequirement(name = "jwt_auth")
        }
)
@SecurityScheme(
        name = "jwt_auth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT"
)
public class SwaggerConfig {

}