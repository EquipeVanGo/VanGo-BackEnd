package com.monqui.van_go.repositories;

import com.monqui.van_go.entities.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripsRepository extends JpaRepository<Trips, Long> {

    @Query("SELECT t FROM Trips t JOIN t.addresses a WHERE a.address = :departure OR a.city = :destination")
    List<Trips> findTripsByDepartureOrDestination(@Param("departure") String departure,
                                                  @Param("destination") String destination);
}
