package wm.gurpswm.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import wm.gurpswm.Firebase.FirebaseAuthenticationFilter;

@Configuration
public class WebSecurityConfig {
    
    @Autowired
    private FirebaseAuthenticationFilter firebaseAuthenticationFilter;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(auth -> 
            auth.requestMatchers("/app/db/insert").authenticated()
            .anyRequest().permitAll()
        )
        .addFilterBefore(firebaseAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .oauth2ResourceServer(rs -> rs.jwt(Customizer.withDefaults()))
        ;
        return http.build();
    }
}
