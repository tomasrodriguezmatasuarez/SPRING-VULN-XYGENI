package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Configuración de seguridad deliberadamente permisiva.
 * Todas las peticiones quedan accesibles sin autenticación ni autorización.
 */
@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .authorizeRequests()
                .anyRequest().permitAll(); // Control de acceso insuficiente
    }
}
