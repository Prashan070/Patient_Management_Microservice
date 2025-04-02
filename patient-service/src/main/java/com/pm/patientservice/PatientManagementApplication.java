package com.pm.patientservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info =@Info(
				title = "Patient Service Rest API",
				description = "Patient Service Rest API discription",
				version = "3.3.2",
				contact = @Contact(
						name = "Prashan",
						email = "test@com.com"
				)
		),externalDocs = @ExternalDocumentation(
				description = "github link",
		url = "Google.com"
)



)


@SpringBootApplication
public class 	PatientManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientManagementApplication.class, args);
	}

}
