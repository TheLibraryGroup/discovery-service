package org.thibaut.thelibrary.discoveryservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure( AuthenticationManagerBuilder auth) throws Exception {
		auth
				.inMemoryAuthentication()
				.passwordEncoder( NoOpPasswordEncoder.getInstance())
				.withUser("discUser")
				.password("discPassword")
				.authorities("ADMIN");
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.csrf().disable()
				.authorizeRequests()
				.mvcMatchers(HttpMethod.GET, "/actuator/**").permitAll()
				.antMatchers(HttpMethod.GET, "/assets/**").authenticated()
				.antMatchers(HttpMethod.GET, "/eureka/**").authenticated()
				.antMatchers(HttpMethod.POST, "/eureka/**").authenticated()
				.antMatchers(HttpMethod.DELETE, "/eureka/**").authenticated()

//				.antMatchers(HttpMethod.GET, "/hystrix/**").permitAll()
//				.antMatchers(HttpMethod.POST, "/hystrix/**").permitAll()
//				.antMatchers(HttpMethod.DELETE, "/hystrix/**").permitAll()
//				.antMatchers(HttpMethod.PUT, "/hystrix/**").permitAll()

				.anyRequest().authenticated().and()
				.httpBasic();
	}

}
