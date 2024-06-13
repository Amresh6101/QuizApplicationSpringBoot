package com.quiz.management.application.swagger;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Quiz Management APIs",
                description = "Quiz Management related all apis",
                contact=@Contact(
                        name = "AmreshRanjan",
                        email = "amresh_ranjan@epam.com"
                ),
                version = "V1"
        ),
        servers = @Server(
                description = "DEV Server",
                url = "http://localhost:8080"
        )
)
public class SwaggerConfig {
}
