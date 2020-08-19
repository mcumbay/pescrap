package com.dfwcomputech.scrap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gargoylesoftware.htmlunit.WebClient;

@Configuration
public class HtmlUnitConfig {
	@Bean
	public WebClient client() {
		
		WebClient client = new WebClient();
		client.getOptions().setCssEnabled(false);
		client.getOptions().setJavaScriptEnabled(false);
		
		return client;
	}
}
