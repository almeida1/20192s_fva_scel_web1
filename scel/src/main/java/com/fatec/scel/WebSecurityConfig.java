package com.fatec.scel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//https://docs.spring.io/spring-security/site/docs/current/guides/html5/helloworld-boot.html
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/fragments/**","/login").permitAll() //estao acessiveis
        .anyRequest().authenticated() //para todos os outros metodos
        .and()
      .formLogin()
        .loginPage("/login").defaultSuccessUrl("/home",true)
        .permitAll() // todos tem acesso a pagina de login
        .and()
      .logout()
      .logoutUrl("/logout")
        .permitAll();
  }

  @Bean
  @Override
  public UserDetailsService userDetailsService() {
    UserDetails user =
       User.withDefaultPasswordEncoder()
        .username("jose")
        .password("123")
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(user);
  }
}