package com.towhid.practicepharmacy.sequrity;

import com.towhid.practicepharmacy.jwt.JwtAuthenticationFilter;
import com.towhid.practicepharmacy.service.UserService;
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
                                        req.requestMatchers("api/medicinegeneric/{id}","/login", "/register","/register/admin", "api/medicine/", "api/medicinegeneric/",
                                                        "api/pharmacist/","api/medicine/save","api/medicinegeneric/save","api/pharmacist/save","api/medicinegeneric/delete/{id}",
                                                        "api/customer/","api/customer/save","/activate/**","api/medicinegeneric/update/{id}","api/product/m/searchmedicine?genericName",
                                                        "api/medicine/delete/{id}","api/medicine/update/{id}","api/salesorder/","api/salesorder/save",
                                                        "api/pharmacist/delete/{id}","api/pharmacist/update/{id}","api/salesmedicine/","api/salesmedicine/save",
                                                        "/api/category/","/api/category/save","/api/category/update/{id}","/api/category/delete/{id}","/api/category/{id}",
                                                        "/api/product/","/api/product/save","/api/product/update/{id}","/api/product/delete/{id}","/api/product/{id}","/api/product/h/searchproduct",
                                                        "/api/sales/","/api/sales/save","/api/sales/delete/{id}")

                                                .permitAll()
                                                .requestMatchers("/currentuser").authenticated()
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
