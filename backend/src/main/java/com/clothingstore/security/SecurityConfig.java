package com.clothingstore.security;

import com.clothingstore.security.filter.AuthenticationFilter;
import com.clothingstore.security.jwt.TokenCreator;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final TokenCreator tokenCreator;

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
                .antMatchers(HttpMethod.GET, "/user/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/user/{email}").access("@userSecurity.isCurrentUser(authentication, #email) or hasAuthority('ROLE_ADMIN')")
                .antMatchers(HttpMethod.POST, "/user/{email}/shippingInfo").access("@userSecurity.isCurrentUser(authentication, #email) or hasAuthority('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/user/{id}").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/order/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET, "/order/user/{email}").access("@userSecurity.isCurrentUser(authentication, #email) or hasAuthority('ROLE_ADMIN')")
                .antMatchers(HttpMethod.PUT, "/order/**").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.DELETE, "/order/**").hasAuthority("ROLE_ADMIN")
                    .and()
                .authorizeRequests().
                anyRequest().permitAll()
                    .and()
                .addFilter(new AuthenticationFilter(authenticationManagerBean(), tokenCreator));
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
