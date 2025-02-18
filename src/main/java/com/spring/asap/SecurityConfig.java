package com.spring.asap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .cors() // Enable CORS
	        .and()
	        .csrf().disable() // Disable CSRF for APIs
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll() // Allow OPTIONS requests
	            .requestMatchers("/api/**").permitAll() // Allow API requests
	            .anyRequest().authenticated()
	        );
	    return http.build();
	}
	
	
	

}

