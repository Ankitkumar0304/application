package com.backend.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {
	@Autowired
	private UserDetailsService userDetailService;
	@Bean
	AuthenticationProvider authenticationProvider () {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.antMatchers("/")
		.permitAll()
		.antMatchers("/login")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
}