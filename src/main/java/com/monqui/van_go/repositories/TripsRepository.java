package com.monqui.van_go.repositories;

import com.monqui.van_go.entities.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface TripsRepository extends JpaRepository<Trips, Long> {

    @Query("SELECT distinct t FROM Trips t WHERE " +
            "LOWER(t.arrivalLocation) LIKE LOWER(CONCAT('%', :destination, '%')) OR " +
            "LOWER(t.departureLocation) LIKE LOWER(CONCAT('%', :departure, '%')) OR " +
            "LOWER(t.arrivalLabel) LIKE LOWER(CONCAT('%', :destination, '%')) OR " +
            "LOWER(t.departureLabel) LIKE LOWER(CONCAT('%', :departure, '%'))")
    List<Trips> findTripsByDepartureOrDestination(@Param("departure") String departure,
                                                  @Param("destination") String destination);

    @Query("SELECT DISTINCT t.departureLocation FROM Trips t WHERE LOWER(t.departureLocation) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "UNION " +
            "SELECT DISTINCT t.arrivalLocation FROM Trips t WHERE LOWER(t.arrivalLocation) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "UNION " +
            "SELECT DISTINCT t.departureLabel FROM Trips t WHERE LOWER(t.departureLabel) LIKE LOWER(CONCAT('%', :text, '%')) " +
            "UNION " +
            "SELECT DISTINCT t.arrivalLabel FROM Trips t WHERE LOWER(t.arrivalLabel) LIKE LOWER(CONCAT('%', :text, '%'))")
    List<String> searchUniqueMatchingTexts(@Param("text") String text);


    @Query("SELECT t FROM Trips t WHERE t.driverId.id = :id")
    List<Trips> findByDriverId_Id(@Param("id") Long id);

    @Query("SELECT t FROM Trips t WHERE t.tripId = :id")
    Optional<Trips> findByTripId(@Param("id") Long id);

    @Query("SELECT DISTINCT t FROM Trips t JOIN FETCH t.tripPassengers tp WHERE tp.passenger.id = :passengerId")
    List<Trips> findTripsByPassengerId(@Param("passengerId") Long passengerId);
}
