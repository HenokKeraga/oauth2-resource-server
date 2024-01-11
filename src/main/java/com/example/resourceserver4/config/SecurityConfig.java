package com.example.resourceserver4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(c -> c.anyRequest().authenticated());

        httpSecurity
                .oauth2ResourceServer(c -> c.opaqueToken(c2 -> c2.introspectionUri("http://localhost:8080/oauth2/introspect").
                        introspectionClientCredentials("client-id","secret")));


        return httpSecurity.build();

    }
}
