package com.epam.ordering.api.swagger;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Swagger configurations 
 * 
 * @author vikashkumar
 *
 */
@Configuration
@EnableCaching
@EnableSwagger2
public class AppConfig {
	
	/**
	 * Method required for Swagger implementation
	 * @return
	 */
	@Bean
	public Docket orderItemApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(orderApiInfo()).groupName("order-service")
				.tags(
				    new Tag("Order", "API for Add or Retrieve Order Details")
					)
					.select().apis(RequestHandlerSelectors.basePackage("com.epam.ordering.api"))
					.paths(PathSelectors.ant("/order/**")).build();

	}

	/**
	 * Method required for Swagger implementation
	 * 
	 * @return {@link ApiInfo}
	 */
	private ApiInfo orderApiInfo() {
		return new ApiInfoBuilder().title("ORDER SERVICE").description("Order Service API")
				.version("1.0").build();
	}


}