package com.wilhelmina.reports;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;


@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
@EnableAspectJAutoProxy
@EnableJpaAuditing

public class Application extends SpringBootServletInitializer {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public Docket documentation() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any()).paths(paths())
				.build().pathMapping("/").useDefaultResponseMessages(false).apiInfo(apiInfo());
	}

	@Bean
	public UiConfiguration uiConfig() {
		return UiConfiguration.DEFAULT;
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Reports REST API").description("SMS Operations").version("2.0")
				.contact("NA").build();
	}

	@SuppressWarnings("unchecked")
	private Predicate<String> paths() {
		return or(regex("/sms.*"));
	}

}
