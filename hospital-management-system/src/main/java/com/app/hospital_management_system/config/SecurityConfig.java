package com.app.hospital_management_system.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

       http.csrf(customizer -> customizer.disable());
        // Disables CSRF (Cross-Site Request Forgery) protection.
        // CSRF is a security feature mainly used for web forms.
        // We disable it in REST APIs because they are usually stateless.
       http.authorizeHttpRequests(request -> request
               .requestMatchers("/register", "/login", "/save")
               .permitAll()
               .requestMatchers("/hospital/**").hasRole("ADMIN")
                       .requestMatchers("/doctor/**").hasRole("DOCTOR")
                       .requestMatchers("/patient/**").hasRole("PATIENT")
                       .anyRequest().authenticated())
               .httpBasic(Customizer.withDefaults())
                       .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                               .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        // This means every request must be authenticated.
        // No API or endpoint can be accessed without login.
    //   http.formLogin(Customizer.withDefaults());        For UI
        // Enables default login form provided by Spring Security.
        // When you open /login, you will see a built-in login page.
        //If you are using only postman for testing api you can remove that line

      //  http.httpBasic(Customizer.withDefaults());
        // Enables HTTP Basic Authentication.
        // Username and password are sent in headers.
        //For postman api testing

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("aman")
//                .password("aman@123")
//                .roles("User")                                                                                     This is the hard coded value , we doesn't use this method
//                .build();                                                                                                We create our own authentication provider via connecting
//                                                                                                                              with database
//        UserDetails admin = User
//                .withDefaultPasswordEncoder()
//                .username("ritik")
//                .password("rirtik@123")
//                .roles("Admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(user1, admin);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
      provider.setPasswordEncoder(new  BCryptPasswordEncoder(12));
   //    provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return  provider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}

