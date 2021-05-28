package com.example.projektai.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("**/admin/**").hasRole("admin")
                .antMatchers("**/moderator/**").hasRole("moderator")
                .antMatchers(HttpMethod.POST,"/films", "/filmScreenings", "/directors").hasRole("moderator")
                .antMatchers(HttpMethod.DELETE,"/films", "/filmScreenings", "/directors", "/opinions").hasRole("moderator")
                .antMatchers(HttpMethod.PUT,"/films", "/filmScreenings", "/directors").hasRole("moderator")
                .anyRequest().permitAll()
                .and().csrf().disable()
                .cors();
    }
}
