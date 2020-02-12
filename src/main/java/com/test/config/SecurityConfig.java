package com.test.config;

import com.test.security.JwtSecurityFilter;
import com.test.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @RequiredArgsConstructor
    public class CoreSecurity extends WebSecurityConfigurerAdapter {

        private final SecurityService securityService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/api/user/register", "/api/user/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .addFilterAfter(jwtSecurityFilter(), SecurityContextPersistenceFilter.class)
                    .csrf().disable()
                    .cors();
        }

        private JwtSecurityFilter jwtSecurityFilter() {
            return new JwtSecurityFilter(securityService);
        }

    }

}
