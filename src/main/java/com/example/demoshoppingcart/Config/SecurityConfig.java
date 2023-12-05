package com.example.demoshoppingcart.Config;

import com.example.demoshoppingcart.handler.CustomerAuthenticationFailureHandle;
import com.example.demoshoppingcart.handler.CustomerAuthenticationSuccessHandler;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth ->
                auth.requestMatchers("/admin*")
                .hasRole("ADMIN")
                .requestMatchers("/login*","signup")
                .permitAll()
                .anyRequest()
                .authenticated()
            )
                .formLogin(formLogin -> formLogin.loginPage("/login")
                        .loginProcessingUrl("/perform_login")
                        .successHandler(authenticationSuccessHandler())
                        .failureHandler(authenticationFalureHandler())
                )
                .logout(logout -> logout.logoutUrl("/perform_logout")
                        .deleteCookies("JSESSIONID"));

        return http.build();
    }

    @Bean
    public AuthenticationFailureHandler authenticationFalureHandler() {

        return new CustomerAuthenticationFailureHandle();
    }

    @Bean
    public AuthenticationSuccessHandler authenticationSuccessHandler() {

        return new CustomerAuthenticationSuccessHandler();
    }


}
