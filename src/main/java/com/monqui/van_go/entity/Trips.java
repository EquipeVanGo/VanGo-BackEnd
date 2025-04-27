package com.monqui.van_go.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.monqui.van_go.entity.location.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_trips")
public class Trips {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tripId;

    @ManyToOne()
    @JoinColumn(name = "id",nullable = false)
    @JsonManagedReference
    private Enterprise enterpriseId;

    @ManyToOne()
    @JsonManagedReference
    private Driver driver;

    @ManyToOne()
    @JsonManagedReference
    private Vehicle vehicle;
    private String departureTime;
    private String departureLocation;
    private String arrivalTime;
    private String arrivalLocation;

    @ManyToMany
    @JoinTable(
            name = "trip_passenger",
            joinColumns = @JoinColumn(name = "trip_id"), // Chave estrangeira para Trips
            inverseJoinColumns = @JoinColumn(name = "passenger_id") // Chave estrangeira para Passenger
    )
    @JsonManagedReference
    private List<Passenger> passengers;

    @ManyToMany
    @JoinTable(
            name = "trip_address", // Nome da tabela intermediária
            joinColumns = @JoinColumn(name = "trip_id"), // Chave estrangeira para Trips
            inverseJoinColumns = @JoinColumn(name = "address_id") // Chave estrangeira para Address
    )
    @JsonManagedReference
    private List<Address> addresses;
}
