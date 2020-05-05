package org.thibaut.thelibrary.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@EnableEurekaServer
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
//@EnableTurbine
public class DiscoveryApplication {

	public static void main( String[] args ) {
		SpringApplication.run( DiscoveryApplication.class, args );
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
