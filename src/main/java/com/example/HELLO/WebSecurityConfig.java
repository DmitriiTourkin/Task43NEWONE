package com.example.HELLO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class WebSecurityConfig {

    /*@Bean
    DataSource user_db() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .setName("usrs")
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }*/

    @Autowired
    DataSource dataSource;

    @Bean
    JdbcUserDetailsManager users(){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        return jdbcUserDetailsManager;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/login", "/registration").permitAll();
                    auth.requestMatchers("/new", "/save", "/edit/*", "/delete/*").hasAuthority("ADMIN");
                    auth.requestMatchers("/static/**").permitAll();
                    auth.anyRequest().authenticated();
                })
                .formLogin(l->{
                    l.loginPage("/login");
                    l.defaultSuccessUrl("/homePage");
                    l.permitAll();
                })
                .logout(LogoutConfigurer::permitAll)
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}

