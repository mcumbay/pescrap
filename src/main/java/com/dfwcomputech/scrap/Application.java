package com.dfwcomputech.scrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

import com.gargoylesoftware.htmlunit.WebClient;

@SpringBootApplication
public class Application {
	
	/**
	 * Example:
	 * http://localhost:8080/pescrap/search?overall_rating=40-79&speed=90-99&form=6-8&explosive_power=80-99
	 * 
	 * */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	

	@Bean
	public WebClient client() {
		
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		
		return client;
	}
	
	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>
	  webServerFactoryCustomizer() {
	    return factory -> factory.setContextPath("/pescrap");
	}
}
