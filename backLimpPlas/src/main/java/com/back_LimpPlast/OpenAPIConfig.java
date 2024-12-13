package com.back_LimpPlast;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConfig {

	@Bean
	OpenAPI customerOpenAPI() {
		
		return new OpenAPI()
	  .info(new Info()
		 .title("DOC SWAGGER")	
		 .version("v1")
		 .description("Docs ")
		 .termsOfService(null)
		 .license(new License().name("Apache 2.0")
	  .url("NAO TEM "))
		
			  )
				;
	}
}
