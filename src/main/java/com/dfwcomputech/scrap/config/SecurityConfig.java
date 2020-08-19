package com.dfwcomputech.scrap.config;

import java.security.SecureRandom;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

import com.dfwcomputech.scrap.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserService userService;

//		 auth
//		    .inMemoryAuthentication()
//		      .withUser("buzz")
//		        .password("infinity")
//		        .authorities("ROLE_USER")
//		      .and()
//		      .withUser("woody")
//		        .password("bullseye")
//		        .authorities("ROLE_USER");

//	@Autowired
//	private DataSource dataSource;
//	  auth
//	    .jdbcAuthentication()
//	      .dataSource(dataSource)
//	      .usersByUsernameQuery(
//	          "SELECT email AS username, password, enabled FROM USERS WHERE email=?")
//	      .authoritiesByUsernameQuery(
//	          "SELECT u.email as username, a.authority from AUTHORITIES as a inner join USERS u on a.userid = u.id where u.email=?");
//	  
	  
	@Bean
	public PasswordEncoder encoder() {
		 int strength = 10; // work factor of bcrypt
		 BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(strength, new SecureRandom());
	  return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	    throws Exception {
		  auth
		    .userDetailsService(userService).passwordEncoder(encoder());
	  
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	  http
	    .authorizeRequests()
	      .antMatchers("/players/**", "/scrap","/search","/home")
	        .access("hasRole('ROLE_USER')")
	      .antMatchers("/", "/**").access("permitAll")
	      .and()
	      .formLogin()
	        .loginPage("/login")
	        .usernameParameter("email")
	        .defaultSuccessUrl("/")
	        .and()
	        .logout()
	         .logoutSuccessUrl("/");
	}
}
