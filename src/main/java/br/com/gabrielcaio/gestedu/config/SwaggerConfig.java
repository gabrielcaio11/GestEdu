package br.com.gabrielcaio.gestedu.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("GestEdu - Manage educational institutions")
                        .version("1.0")
                        .description("Gest Edu is a web application designed to manage educational institutions, including schools and colleges. It provides features for managing students, teachers, courses, and more."));
    }
}