package com.login.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Configuration
@EnableWebMvc
public class SwaggerConfig implements WebMvcConfigurer {

	List<String> lista = Arrays.asList("https", "http");
	Set<String> protocolo = new HashSet<String>(lista);

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("Servicios Club villa Elvira")
						.version("1.0")
						.description("Documentación de los servicios de Club Villa Elvira")
						.contact(new Contact()
								.name("Practica 2")
								.email("practica2@gmail.com") // opcional

						)
				)
				/*.servers(List.of(
						new Server().url("https://api.tuservicio.com").description("Producción segura"),
						new Server().url("http://localhost:8080").description("Entorno local")
				))*/
				.addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
				.components(new Components()
						.addSecuritySchemes("bearerAuth",
								new SecurityScheme()
										.name("Authorization")
										.type(SecurityScheme.Type.HTTP)
										.scheme("bearer")
										.bearerFormat("JWT")
						)
				);
	}
}
