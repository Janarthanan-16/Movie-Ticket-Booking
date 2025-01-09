package com.project.movieticketbooking.config;

import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class CorsConfig {

	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedOrigin("http://localhost:5173");
		config.addAllowedMethod("*");
		config.addAllowedHeader("*");
		config.setAllowCredentials(true);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);

	}

	@Bean
	public OpenAPI swaggerDocApi() {

		Server server1 = new Server();
		server1.setUrl("http://localhost:8080/");
		server1.setDescription("Server for local Testing");

		Server server2 = new Server();
		server2.setUrl("http://192.168.188.251:8080/");
		server2.setDescription("Server for remote testing");

		Contact co = new Contact();
		co.setEmail("");
		co.setName("");
		co.setUrl("");

		License license = new License();
		license.setName("License Provider: Approved by Google");
		license.setUrl("www.google.com");

		Info info = new Info();
		info.setContact(co);
		info.setLicense(license);
		info.setDescription(" Test Application for the Movie Ticket Booking");
		info.setTermsOfService(" Url for terms and services ");
		info.setTitle("Movie Ticket Booking");
		info.setVersion("1.5");

		OpenAPI api = new OpenAPI();
		api.setInfo(info);
		api.setServers(Arrays.asList(server1, server2));
		return api;
	}
}
