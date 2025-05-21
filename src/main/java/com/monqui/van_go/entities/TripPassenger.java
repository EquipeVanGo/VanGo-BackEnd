package com.monqui.van_go.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "trip_passenger")
public class TripPassenger {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    @JsonBackReference
    private Trips trip;

    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    private String departureLabel;
    private String arrivalLabel;

    public TripPassenger() {}

    public TripPassenger(Trips trip, Passenger passenger, String departureLabel, String arrivalLabel) {
        this.trip = trip;
        this.passenger = passenger;
        this.departureLabel = departureLabel;
        this.arrivalLabel = arrivalLabel;
    }

    public String getArrivalLabel() {
        return arrivalLabel;
    }

    public void setArrivalLabel(String arrivalLabel) {
        this.arrivalLabel = arrivalLabel;
    }

    public String getDepartureLabel() {
        return departureLabel;
    }

    public void setDepartureLabel(String departureLabel) {
        this.departureLabel = departureLabel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Trips getTrip() {
        return trip;
    }

    public void setTrip(Trips trip) {
        this.trip = trip;
    }
}

