package com.interim.doctorAppointmentBooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.interim.doctorAppointmentBooking.service.AuthService;

@EnableWebSecurity
@Configuration
@PropertySource("classpath:application.properties")
public class SecurityConfig {

    @Autowired
    private AuthService authService;

    @Autowired
    private JWTFilter jwtFilter;

    @Bean
    public BCryptPasswordEncoder pwdEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider(authService);
        authProvider.setPasswordEncoder(pwdEncoder());
        return authProvider;

    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((req) ->{ req
                        .requestMatchers("/appointmentapi/register","/appointmentapi/login","/docspot/**").permitAll()
                        .requestMatchers("/appointmentapi/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/appointmentapi/doctor/**").hasAuthority("DOCTOR")
                        .requestMatchers("/appointmentapi/patient/**").hasAuthority("PATIENT")
                        .anyRequest()
                        .authenticated();
                })
                .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
                .headers(header -> header.frameOptions(frame -> frame.disable()))
                .csrf(csrf -> csrf.disable());
        return http.build();
    }

}