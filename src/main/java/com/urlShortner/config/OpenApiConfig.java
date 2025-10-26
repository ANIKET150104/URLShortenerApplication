package com.urlShortner.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(

                contact = @Contact(
                        name = "Aniket Singh",
                        email = "aniket1501singh@gmail.com",
                        url = "https://github.com/ANIKET150104"
                ),
                version = "1.0",
                description = "Documentation for URL shortner Application",
                title = "Open Api Doc",
                license = @License(
                        name = "Partner-Finder",
                        url = "License : https://github.com/ANIKET150104"

                ),
                summary = "API Documentation for Online-URL shortner Application App"

        ),
        servers = {

                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8080"
                )
        }

)
public class OpenApiConfig {

}
