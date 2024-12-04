package com.monqui.van_go.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monqui.van_go.entities.Driver;

public interface DriverRepository extends JpaRepository<Driver, Long>{

    List<Driver> findByEnterpriseId(Long enterpriseId);
    
    List<Driver> findByActiveTrue();
    
    
    // Validação temporária
    
    Optional<Driver> findByEmailAndPassword(String email, String password);
    

}
