package com.monqui.van_go.config;

import com.monqui.van_go.repositories.DriverRepository;
import com.monqui.van_go.repositories.EnterpriseRepository;
import com.monqui.van_go.repositories.PassengerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PassengerRepository passengerRepository;
    private final EnterpriseRepository enterpriseRepository;
    private final DriverRepository driverRepository;

    public CustomUserDetailsService(
            PassengerRepository passengerRepository,
            EnterpriseRepository enterpriseRepository,
            DriverRepository driverRepository
    ) {
        this.passengerRepository = passengerRepository;
        this.enterpriseRepository = enterpriseRepository;
        this.driverRepository = driverRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return passengerRepository.findByEmail(email).<UserDetails>map(p -> p)
                .or(() -> enterpriseRepository.findByEmail(email).map(e -> e))
                .or(() -> driverRepository.findByEmail(email).map(d -> d))
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com email: " + email));
    }
}

