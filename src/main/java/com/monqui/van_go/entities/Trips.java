package com.monqui.van_go.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.monqui.van_go.entities.location.Address;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tb_trips")
public class Trips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    @JsonManagedReference
    private Enterprise enterpriseId;

    @ManyToOne()
    @JoinColumn(name = "driver_id",referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private Driver driverId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id",referencedColumnName = "id", nullable = false)
    @JsonManagedReference
    private Vehicle vehicleId;

    private LocalDateTime departureTime;
    private String departureLocation;
    private String departureLabel;
    private LocalDateTime arrivalTime;
    private String arrivalLocation;
    private String arrivalLabel;
    private String pngRoute;

    @ManyToMany
    @JoinTable(
            name = "trip_passenger",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id")
    )
    @JsonManagedReference
    private List<Passenger> passengers;

    @ManyToMany
    @JoinTable(
            name = "trip_address",
            joinColumns = @JoinColumn(name = "trip_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    @JsonManagedReference
    private List<Address> addresses;

 
    public Trips() {
    }

  
    public Trips(Long tripId, Enterprise enterpriseId, Driver driver, Vehicle vehicle,
                 LocalDateTime departureTime, String departureLocation,String departureLabel, LocalDateTime arrivalTime,
                 String arrivalLocation, String arrivalLabel, String pngRoute, List<Passenger> passengers, List<Address> addresses) {
        this.tripId = tripId;
        this.enterpriseId = enterpriseId;
        this.driverId = driver;
        this.vehicleId = vehicle;
        this.departureTime = departureTime;
        this.departureLocation = departureLocation;
        this.departureLabel = departureLabel;
        this.arrivalTime = arrivalTime;
        this.arrivalLocation = arrivalLocation;
        this.arrivalLabel = arrivalLabel;
        this.pngRoute = pngRoute;
        this.passengers = passengers;
        this.addresses = addresses;
    }


    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Enterprise getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Enterprise enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public Driver getDriverId() {
        return driverId;
    }

    public void setDriverId(Driver driverId) {
        this.driverId = driverId;
    }

    public Vehicle getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Vehicle vehicle) {
        this.vehicleId = vehicle;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getDepartureLabel() {
        return departureLabel;
    }

    public void setDepartureLabel(String departureLabel) {
        this.departureLabel = departureLabel;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public String getArrivalLabel() {
        return arrivalLabel;
    }
    public void setArrivalLabel(String arrivalLabel) {
        this.arrivalLabel = arrivalLabel;
    }
    public String getPngRoute() {
        return pngRoute;
    }

    public void setPngRoute(String pngRoute) {
        this.pngRoute = pngRoute;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
