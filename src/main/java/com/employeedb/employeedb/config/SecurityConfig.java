package com.employeedb.employeedb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
         return httpSecurity
                 .authorizeHttpRequests(
                         authorizeHttp -> {
                             authorizeHttp.requestMatchers("/").permitAll();
                             authorizeHttp.requestMatchers("/api/auth/login_admin").permitAll();
                             authorizeHttp.requestMatchers("/api/auth/register-admin").permitAll();
                             authorizeHttp.anyRequest().authenticated();
                         }
                 )
                 .addFilterBefore(new SecurityFilter(), AuthenticationFilter.class)
                 .build();

    }
}
