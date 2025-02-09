package com.spring.asap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    
	@SuppressWarnings({ "removal", "deprecation" })
	@Bean
	public SecurityFilterChain customSecurityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .cors()  // Enable CORS, if you have custom CORS configuration
	        .and()
	        .csrf().disable()
	        .authorizeRequests()
	            .anyRequest().permitAll()  // Allow all requests without authentication
	        .and()
	        .httpBasic();  // Optional: still enables HTTP Basic if you plan to use it later

	    return http.build();
	}

}

