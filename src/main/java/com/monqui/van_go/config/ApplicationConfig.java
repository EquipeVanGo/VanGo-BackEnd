package com.monqui.van_go.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.monqui.van_go.repositories.DriverRepository;
import com.monqui.van_go.repositories.EnterpriseRepository;
import com.monqui.van_go.repositories.PassengerRepository;

@Configuration
public class ApplicationConfig {

    private final PassengerRepository passengerRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final DriverRepository driverRepository;

    public ApplicationConfig(
            PassengerRepository passengerRepository,
            EnterpriseRepository enterpriseRepository,
            DriverRepository driverRepository
    ) {
        this.passengerRepository = passengerRepository;
        this.enterpriseRepository = enterpriseRepository;
        this.driverRepository = driverRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            Optional<? extends UserDetails> user =
                    passengerRepository.findByEmail(username)
                            .map(p -> (UserDetails) p)
                            .or(() -> enterpriseRepository.findByEmail(username).map(e -> (UserDetails) e))
                            .or(() -> driverRepository.findByEmail(username).map(d -> (UserDetails) d));

            return user.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + username));
        };
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
}
