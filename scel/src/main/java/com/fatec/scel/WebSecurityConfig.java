package com.fatec.scel;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//https://docs.spring.io/spring-security/site/docs/current/guides/html5/helloworld-boot.html
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private Environment env;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (Arrays.asList(env.getActiveProfiles()).contains("h2")) {
			http.headers().frameOptions().disable();
		}

		http.authorizeRequests().antMatchers("/fragments/**", "/login").permitAll() // estao acessiveis
				.and().authorizeRequests().antMatchers("/h2-console").permitAll() // permite o acesso ao h2 deve ser
																					// retirado no ambiente de producao
				.anyRequest().authenticated() // para todos os outros acessos deve ser autenticado
				.and().formLogin().loginPage("/login").defaultSuccessUrl("/home", true).permitAll() // todos tem acesso
																									// a pagina de login
				.and().logout().logoutUrl("/logout").permitAll();
		http.csrf().disable();

	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("jose").password(bcryptPasswordEncoder().encode("123")).roles("USER").build();

		return new InMemoryUserDetailsManager(user);
	}
	@Bean
	public BCryptPasswordEncoder bcryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}