package com.ecommerce.backend;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
						name = "Admin",
						email = "example@example.com",
						url = "https://back.admin.com"
				),
				description = "OpenApi documentation for String Security",
				title = "OpenApi Specification ",
				version = "0.1",
				license = @License(
						name = "Licence name backend",
						url = "https://licend.backend.com"
				),
				termsOfService = "Terms of service"
		)
)
@SecurityScheme(
		name = "bearerAuth",
		description = "JWT auth description",
		scheme = "bearer",
		type= SecuritySchemeType.HTTP,
		bearerFormat = "JWT",
		in = SecuritySchemeIn.HEADER

)
public class BackendApplication {
	public static void main(String[] args){
		SpringApplication.run(BackendApplication.class, args);
	}

}
