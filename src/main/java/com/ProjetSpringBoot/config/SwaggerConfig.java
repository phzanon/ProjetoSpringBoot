package com.ProjetSpringBoot.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig extends WebMvcConfigurationSupport{
	
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.ProjetoSpringBoot.rest"))
				.paths(regex("/consulta.*"))
				.build()
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
		return new ApiInfoBuilder()
				.title("Spring Boot REST API")
				.description("\"Spring Boot REST API for Online Store\"")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/license/LICENSE-2.0\"")
				.contact(new Contact("Valid Certificadora", "www.validcertificadora.com.br/", "pzanon.mazzatech@ext.valid.com"))
				.build();
	}
	
	
	
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		
		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:META-INF/resources/webjars/");
	}
	
	
}
