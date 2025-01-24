package com.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static  org.springframework.security.config.Customizer.withDefaults;;
@Configuration
public class SpringSecurityConfiguration {
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
		
		//all requests are to be secure
		http.authorizeHttpRequests(auth->auth.anyRequest().authenticated());
		
		// if a request is not authenticated a webpage is shown 
		http.httpBasic(withDefaults()); // it will show basic autherization popup 
		
		
		//didable csrf ., so that post requests can be made
		http.csrf().disable();
		
		return http.build();
	}
	
}
