package com.towhid.pharmacyManagement.sequrity;

import com.towhid.pharmacyManagement.jwt.JwtAuthenticationFilter;
import com.towhid.pharmacyManagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SequrityConfig {

    private final UserService userService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        return
                http
                        .csrf(AbstractHttpConfigurer::disable)
                        .authorizeHttpRequests(

                                req ->
                                        req.requestMatchers("api/medicinegeneric/{id}","/login", "/register", "api/medicine/", "api/medicinegeneric/","api/pharmacist/","api/medicine/save","api/medicinegeneric/save","api/pharmacist/save","api/medicinegeneric/delete/{id}","api/customer/","api/customer/save","/activate/**","api/medicinegeneric/update/{id}")
                                                .permitAll()
                                                .requestMatchers("api/medicine/save", "api/medicinegeneric/save")
                                                .hasAuthority("ADMIN")
                                                .requestMatchers( "api/medicine/{id}","api/pharmacist/all/**", "api/location/")
                                                .hasAnyAuthority("ADMIN", "PHARMACIST")
                                                .requestMatchers("api/user/**")
                                                .hasAuthority("USER")
                                                .requestMatchers("/images/**").permitAll()

                        )
                        .userDetailsService(userService)
                        .sessionManagement(
                                session ->
                                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        )
                        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                        .build();


    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


}
