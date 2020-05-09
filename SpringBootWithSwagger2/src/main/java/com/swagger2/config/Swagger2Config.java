package com.swagger2.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableWebMvc
@EnableSwagger2
public class Swagger2Config implements WebMvcConfigurer{

	/** the application context */
	ApplicationContext applicationContext;
	
	@Bean
	public Docket api()
	{
	 return new Docket(DocumentationType.SWAGGER_2).select()
			 .apis(RequestHandlerSelectors.basePackage("com.swagger2"))
			 .paths(PathSelectors.any())
			 .build()
			 .apiInfo(apiInfo());
	}
	
	/* api info */
	
	private ApiInfo apiInfo() {
		
		return new ApiInfoBuilder().title("Spring Boot REST API-Swagger-Doc's,here actual service name")
				.description("Employee Management REST API"
						+"This API will be hosted in dev environment"
						+"</br> following DATE format need to be used in Employee management"
						+"</br>brithdate : YYYY-MM-DD"
						+"</br>Expiration date should be  : YYYY-MM-DD")
				.version("1.0")
				.contact(new Contact("Team name,ABC interface", "", "abc@xyz.com"))
				.license("Detailed API Specification Documents")
				.licenseUrl("\"http://www.apache.org/licenses/LICENSE-2.0.html\"")
				.build();
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
	
	public void ApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	
}
