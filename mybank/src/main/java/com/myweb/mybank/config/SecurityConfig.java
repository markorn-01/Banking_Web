// package com.myweb.mybank.config;

// import java.util.Arrays;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.userdetails.User;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfig {
//      @Bean
//      InMemoryUserDetailsManager users(){
//         return new InMemoryUserDetailsManager(
//             User.withUsername("minh")
//                 .password("{noop}password")
//                 .roles("USER")
//                 .build()
//         );
//      }

//      @Bean
//      SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         return http
//             .cors(Customizer.withDefaults())
//             .authorizeRequests(auth -> auth
//                 .anyRequest().authenticated())
//             .httpBasic(Customizer.withDefaults())
//             .build();
//      }
//      @Bean
//      CorsConfigurationSource corsConfigurationSource(){
//         CorsConfiguration cors = new CorsConfiguration();
//         cors.setAllowedOrigins(Arrays.asList("http://localhost:5500"));
//         cors.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
//         cors.setAllowedHeaders(Arrays.asList("*"));
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", cors);
//         return source;
//      }
// }
