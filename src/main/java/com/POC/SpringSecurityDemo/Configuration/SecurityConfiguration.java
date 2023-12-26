package com.POC.SpringSecurityDemo.Configuration;

import com.POC.SpringSecurityDemo.Services.customUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfiguration {
   // table is create in database
    // normal user role has user name - user , password -user
    // admin user role has user name - admin, password - admin

    UserDetailsService userDetailsService ;

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.    authorizeHttpRequests(auth->auth
                .requestMatchers("/add","/home").permitAll()
                .requestMatchers("/AdminLogin").hasRole("ADMIN")
                .requestMatchers("/UserLogin").hasRole("NORMAL")
                .anyRequest()
                .authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
    // in memory database for user role and permissions

   /* @Bean
    public UserDetailsService userDetailsService() {
*//*
        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
                .build();
        UserDetails normal = User.builder().username("normal").password(passwordEncoder().encode("normal")).roles("NORMAL")
                .build();
        return new InMemoryUserDetailsManager(admin,normal);*//*

        return new customUserDetailsService();
    }*/
  /*  @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }*/
    // using our own database for user role and permission
 @Bean
 public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
     return configuration.getAuthenticationManager();
 }

}
