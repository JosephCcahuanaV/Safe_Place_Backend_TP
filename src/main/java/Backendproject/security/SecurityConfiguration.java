package Backendproject.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {
    /*
    http://localhost:8080/swagger-ui/index.html
    */
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
            // -- login
            "/api/login/**"
    };

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration
                                                        authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Autowired
    private JwtRequestFilter jwtRequestFilter;


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        http.csrf().disable();
        http.cors(withDefaults());



        http.authorizeHttpRequests( (auth) ->auth
                .antMatchers(AUTH_WHITELIST).permitAll()

                //CLIENT
                .antMatchers("/api/clients").hasRole("ADMIN")
                .antMatchers("/api/clients/create").hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/api/clients/delete/{id}").hasRole("ADMIN")
                .antMatchers("/api/clients/create").hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/api/clients/update/{id}").hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/api/clients/{id}").hasAnyRole("CLIENT","ADMIN")


                //CONTRACT
                .antMatchers("/api/contracts").hasRole("ADMIN")
                .antMatchers("/api/contracts/create").hasAnyRole("RENDER","ADMIN","CLIENT")
                .antMatchers("/api/contracts/{id}").hasAnyRole("RENDER","ADMIN","CLIENT")
                .antMatchers("/api/contracts/delete/{id}").hasRole("ADMIN")

                //BOOKING
                .antMatchers("/api/bookings").hasAnyRole("CLIENT","RENDER","ADMIN")
                .antMatchers("/api/bookings/create").hasAnyRole("CLIENT","RENDER","ADMIN")
                .antMatchers("/api/bookings/{id}").hasAnyRole("CLIENT","RENDER","ADMIN")
                .antMatchers("/api/bookings/delete/{id}").hasRole("ADMIN")


                //LOCAL
                .antMatchers("/api/locals").hasAnyRole("RENDER","ADMIN")
                .antMatchers("/api/locals/create").hasAnyRole("RENDER","ADMIN")
                .antMatchers("/api/locals/{id}").hasAnyRole("RENDER","ADMIN")
                .antMatchers("/api/locals/update/{id}").hasAnyRole("RENDER","ADMIN")
                .antMatchers("/api/locals/delete/{id}").hasRole("ADMIN")

                //REVIEW

                .antMatchers("/api/reviews").hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/api/reviews/create").hasAnyRole("RENDER","ADMIN")
                .antMatchers("/api/reviews/delete/{id}").hasRole("ADMIN")
                .antMatchers("/api/reviews/{id}").hasAnyRole("CLIENT","ADMIN")

                //RENTER

                .antMatchers("/api/renters").hasRole("ADMIN")
                .antMatchers("/api/renters/create").hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/api/renters/delete/{id}").hasRole("ADMIN")
                .antMatchers("/api/renters/create").hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/api/renters/update/{id}").hasAnyRole("CLIENT","ADMIN")
                .antMatchers("/api/renters/{id}").hasAnyRole("CLIENT","ADMIN")



                //.antMatchers("/api/clients/{id}").hasAnyRole("CLIENT")
                .anyRequest().authenticated()
        );



        http.sessionManagement( (session)-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));



        return http.build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}

