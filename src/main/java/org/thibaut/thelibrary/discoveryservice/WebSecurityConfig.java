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
				.csrf().disable() //
				.authorizeRequests() //
				.mvcMatchers(HttpMethod.GET, "/actuator/**").permitAll() // eureka client
				.antMatchers(HttpMethod.GET, "/eureka/**").authenticated() // eureka client
				.antMatchers(HttpMethod.POST, "/eureka/**").authenticated() // eureka client
				.antMatchers(HttpMethod.DELETE, "/eureka/**").authenticated() // eureka client
				.anyRequest().authenticated().and()
				.httpBasic(); // dashboard authorization
	}

//	@Override
//	protected void configure( HttpSecurity http ) throws Exception {
//		http.sessionManagement( )
//				.sessionCreationPolicy( SessionCreationPolicy.ALWAYS )
////				.and( ).requestMatchers( ).antMatchers( "/eureka/**" )
//				.and( ).authorizeRequests( ).mvcMatchers( "/eureka/**" ).hasAnyRole( "ADMIN", "admin" )
////				.anyRequest( ).denyAll( )
//				.and( ).httpBasic( ).and( ).csrf( ).disable( );
//	}
}
