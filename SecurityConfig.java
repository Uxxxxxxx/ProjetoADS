package com.projeto.ads.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {

@Bean
public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
}//fim metodo
	
@Bean
public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
	return configuration.getAuthenticationManager();
}//fim AuthenticationManager

@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
	http.csrf().disable()
		.authorizeRequests(authorize ->
			authorize
			.antMatchers("/css/**", "/js/**").permitAll()
			.antMatchers("/usuario/inserir").permitAll()
			.antMatchers("/usuario/recuperarSenha").permitAll()
			.antMatchers("/usuario/atualizarUsuario").permitAll()
			.anyRequest().authenticated() //todas as requisições precisam de autenticação
		)
		.formLogin(form ->
			form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.successHandler((request, response, authentication)->response.sendRedirect("/dashboard"))
				.permitAll() //permite acesso publico ao nosso formulario de login
		);
	return http.build();
}//fim metodo securityFilterChain
}//fim classe
