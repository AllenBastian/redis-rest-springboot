package com.todo.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  {

    @Autowired
    private UserDetailsService myUserDetailsService;



    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((request)->
                request.requestMatchers("/api/auth/login").
                        permitAll().anyRequest().permitAll());
        http.csrf(customizer->customizer.disable());
        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(){

        DaoAuthenticationProvider myAuthProvider = new DaoAuthenticationProvider();
        myAuthProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        myAuthProvider.setUserDetailsService(myUserDetailsService);
        myAuthProvider.setHideUserNotFoundExceptions(false);

        return new ProviderManager(myAuthProvider);

    }



}
