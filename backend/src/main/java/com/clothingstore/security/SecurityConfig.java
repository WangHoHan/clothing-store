package com.clothingstore.security;

import com.clothingstore.security.filter.AuthenticationFilter;
import com.clothingstore.security.filter.AuthorizationFilter;
import com.clothingstore.security.jwt.TokenCreator;
import com.clothingstore.security.jwt.TokenVerifier;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final TokenCreator tokenCreator;
    private final TokenVerifier tokenVerifier;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/product/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/product/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/product/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT, "/productInfo/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/category").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/category/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/category/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT, "/stock/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/stock/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers("/image/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/user").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/user/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/order").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.PUT, "/order/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/order/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests().
                anyRequest().permitAll()
                    .and()
                .addFilter(new AuthenticationFilter(authenticationManagerBean(), tokenCreator))
                .addFilterBefore(new AuthorizationFilter(tokenVerifier), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
