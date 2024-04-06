//package com.guvi.userManagementApp.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//    JwtTokenFilter jwtTokenFilter;
//    @Bean
//    public  static PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.csrf().disable()
//                .authorizeHttpRequests((authorize) ->{
//
//                    authorize .requestMatchers(HttpMethod.GET,"/api/todos").hasAnyRole("USER","ADMIN");
//                    authorize .requestMatchers(HttpMethod.POST,"/api/todos").hasRole("ADMIN");
//                    authorize .requestMatchers(HttpMethod.POST,"/api/auth/**").permitAll();
//
//                    authorize .anyRequest().authenticated();
//                }).sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        return httpSecurity.build();
//
//    }
//}
