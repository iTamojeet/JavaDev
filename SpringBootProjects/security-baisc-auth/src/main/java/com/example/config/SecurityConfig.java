package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((t)->
                        t.requestMatchers(HttpMethod.GET,"/api/**").permitAll()
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails tamo = User.builder()
                .username("tamo")
                .password(bCryptPasswordEncoder().encode("igloo"))
                .roles("USER")
                .build();
        UserDetails koyel = User.builder()
                .username("koyel")
                .password(bCryptPasswordEncoder().encode("netaji"))
                .roles("ADMIN")
                .build();
        UserDetails gandu = User.builder()
                .username("gandu")
                .password(bCryptPasswordEncoder().encode("mango"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(tamo, koyel, gandu);
    }
    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests((t)->t.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeHttpRequests((t)->t.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests((t)->t.anyRequest().authenticated())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }
}
