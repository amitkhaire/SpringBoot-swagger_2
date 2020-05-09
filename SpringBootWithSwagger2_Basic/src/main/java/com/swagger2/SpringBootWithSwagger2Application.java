package com.swagger2;

import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootWithSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithSwagger2Application.class, args);
	}
	
	@Bean
	public Docket getSwaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/api/*"))
				.apis(RequestHandlerSelectors.basePackage("com.swagger2"))
				.build()
				.apiInfo(apiDetails());
		
	}

	private ApiInfo apiDetails()
	{
		return new ApiInfo("Address Book API",
				"SImple Api for Spring Boot with Swagger2",
				"1.0",
				"free to use",
				new springfox.documentation.service.Contact("name eg.roy thomous", "https://abc.io", "abc.com"),
				"Api License",
				"https://abc.io",
				Collections.emptyList());
	}
}
