package com.internship.doctorAppointmentBooking.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.internship.doctorAppointmentBooking.service.AuthService;

@EnableWebSecurity
@Configuration
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
        DaoAuthenticationProvider authProvider= new DaoAuthenticationProvider();
        authProvider.setPasswordEncoder(pwdEncoder());
        authProvider.setUserDetailsService(authService);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain security(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((req) ->{ req
                        .requestMatchers("/appointmentapi/register","/appointmentapi/login").permitAll()
                        .requestMatchers("/appointmentapi/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/appointmentapi/doctor/**").hasAuthority("DOCTOR")
                        .requestMatchers("/appointmentapi/patient/**").hasAuthority("PATIENT")
                        .anyRequest()
                        .authenticated();
                })
                .addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class)
                .headers(Customizer -> Customizer.frameOptions(frameCustomizer -> frameCustomizer.disable()))
                .csrf(Customizer -> Customizer.disable());
        return http.build();
    }

}
