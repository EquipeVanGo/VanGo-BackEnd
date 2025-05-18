package com.monqui.van_go.repositories;

import com.monqui.van_go.entities.location.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    List<Address> findByAddressContainingIgnoreCase(String addressPart);
}
