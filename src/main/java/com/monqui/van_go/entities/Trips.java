package com.monqui.van_go.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.monqui.van_go.entities.location.Address;
import jakarta.persistence.*;

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

    @ManyToOne
    @JsonManagedReference
    private Driver driver;

    @ManyToOne
    @JsonManagedReference
    private Vehicle vehicle;

    private String departureTime;
    private String departureLocation;
    private String arrivalTime;
    private String arrivalLocation;
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
                 String departureTime, String departureLocation, String arrivalTime,
                 String arrivalLocation, String pngRoute, List<Passenger> passengers, List<Address> addresses) {
        this.tripId = tripId;
        this.enterpriseId = enterpriseId;
        this.driver = driver;
        this.vehicle = vehicle;
        this.departureTime = departureTime;
        this.departureLocation = departureLocation;
        this.arrivalTime = arrivalTime;
        this.arrivalLocation = arrivalLocation;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
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
