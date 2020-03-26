package org.thibaut.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.stereotype.Component;


@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServiceApplication {

	public static void main( String[] args ) {
		SpringApplication.run( DiscoveryServiceApplication.class, args );
	}

//	@Bean
//	public SecurityWebFilterChain springSecurityFilterChain( ServerHttpSecurity http,
//	                                                         ReactiveClientRegistrationRepository clientRegistrationRepository) {
//
//		// Require authentication for all requests
//		http.cors().and().authorizeExchange().anyExchange().permitAll();
//
//		// Allow showing /home within a frame
////		http.headers().frameOptions().mode( XFrameOptionsServerHttpHeadersWriter.Mode.SAMEORIGIN);
//
//		// Disable CSRF in the gateway to prevent conflicts with proxied service CSRF
//		http.csrf().disable();
//		return http.build();
//	}
}
