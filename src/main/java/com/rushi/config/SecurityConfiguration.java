package com.rushi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.rushi.service.UserService;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	
	
	
	
	@Autowired
	private UserService userService;
	
	@Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	 
	  

	 
	 
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
	        return security.csrf(csrf -> csrf.disable())
	                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
	                .formLogin(login -> login.loginPage("/registration")
	                        .loginProcessingUrl("/login")
	                        .defaultSuccessUrl("/user")
	                        
	                        .permitAll())
	                
	                
	        		
	        		
	                .logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	                		.logoutSuccessUrl("/login?logout")
	                		
	                		.permitAll())
	                .build();

	    }

	    @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
	        return configuration.getAuthenticationManager();
	    }
	    
	}
	
	
	
	
	
	