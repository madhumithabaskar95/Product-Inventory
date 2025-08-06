package com.springbootapplication.productinventory.config;

import com.rabbitmq.client.Return;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;
@Configuration
public class SecurityConfiguration {

    @Value("${security.disabled:true}")
    private boolean securityDisabled;

    @Value("#{'${api.config.unsecured:/**}'.split(',')}")
    private List<String> unsecuredPaths;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

          return http
                    .authorizeHttpRequests(authz -> authz
                            .requestMatchers(unsecuredPaths.toArray(new String[0])).permitAll()
                            .anyRequest().permitAll()
                    )
                    .csrf(csrf -> csrf.disable())
                    .formLogin(form -> form.disable())
                    .httpBasic(httpBasic -> httpBasic.disable()).build();
    }
}