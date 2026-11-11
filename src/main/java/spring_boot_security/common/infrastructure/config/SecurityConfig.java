package spring_boot_security.common.infrastructure.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import spring_boot_security.common.infrastructure.filters.JwtFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) //petitions from other domains are not allowed
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers(
//                                "/api/v1/products/**",
                                        "/api/v1/users/login",
                                        "/api/v1/users/register",
                                        "/v3/api-docs/**", //see our api is public, do not require authentication
                                        "/swagger-ui/**",
                                        "/swagger-ui.html",
                                        "/proxy/**"
                                ).permitAll()
                                .requestMatchers("/actuator/**").hasAuthority("ADMIN")
                                .anyRequest().authenticated()//any other request needs to be authenticated
                )
                .formLogin(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults()) //NOT TYPICAL FOR API REST, MORE FOR WEB SESSIONS
                .sessionManagement(
                        session ->
                                session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

}
