package com.example.jawaclinicnew.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import static com.example.jawaclinicnew.domain.Permission.*;
import static com.example.jawaclinicnew.domain.Role.ADMIN;
import static com.example.jawaclinicnew.domain.Role.MANAGER;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;


    @Bean
    MvcRequestMatcher.Builder mvc(HandlerMappingIntrospector introspector) {
        return new MvcRequestMatcher.Builder(introspector).servletPath("/spring-mvc");
    }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http, MvcRequestMatcher.Builder mvc) throws Exception {
      http
              .authorizeRequests(authorizeRequests ->
                      authorizeRequests
                              .requestMatchers(antMatcher("/api/v1/auth/**")).permitAll()
                              .requestMatchers(antMatcher("/api/v1/auth/sendOTP")).permitAll()
                              .requestMatchers(mvc.pattern("/api/v1/management/**")).hasAnyRole(ADMIN.name(), MANAGER.name())
                              .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/v1/management/**")).hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name())
                              .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/v1/management/**")).hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name())
                              .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/v1/management/**")).hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name())
                              .requestMatchers(mvc.pattern(HttpMethod.DELETE, "/api/v1/management/**")).hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name())
                              .requestMatchers(mvc.pattern("/api/v1/admin/**")).hasRole(ADMIN.name())
                              .requestMatchers(mvc.pattern(HttpMethod.GET, "/api/v1/admin/**")).hasAuthority(ADMIN_READ.name())
                              .requestMatchers(mvc.pattern(HttpMethod.POST, "/api/v1/admin/**")).hasAuthority(ADMIN_CREATE.name())
                              .requestMatchers(mvc.pattern(HttpMethod.PUT, "/api/v1/admin/**")).hasAuthority(ADMIN_UPDATE.name())
                              .requestMatchers(mvc.pattern(HttpMethod.DELETE, "/api/v1/admin/**")).hasAuthority(ADMIN_DELETE.name())
                              .anyRequest().authenticated()
              )
              .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(sessionManagement ->
                    sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
            .logout(logout ->
                    logout
                            .logoutUrl("/api/v1/auth/logout")
                            .addLogoutHandler(logoutHandler)
                            .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
            );

    return http.build();
  }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .build();
    }
}
