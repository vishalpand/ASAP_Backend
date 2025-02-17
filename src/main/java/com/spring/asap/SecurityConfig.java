package com.spring.asap;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
	                .requestMatchers("/api/**").permitAll() // Allow API requests
	                .anyRequest().authenticated()
	            );
	        return http.build();
	    }
	 
	 
	 
//	 @Bean
//	    public CorsFilter corsFilter() {
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        config.setAllowedOrigins(List.of("http://localhost:8100", "https://asap.up.railway.app"));
//	        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
//	        config.setAllowedHeaders(List.of("*"));
//	        config.setAllowCredentials(true);
//	        source.registerCorsConfiguration("/**", config);
//	        return new CorsFilter(source);
//	    }

}

