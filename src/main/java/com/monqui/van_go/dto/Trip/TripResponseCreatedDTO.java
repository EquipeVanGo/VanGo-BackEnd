package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.entities.Trips;

import java.time.LocalDateTime;

public class TripResponseCreatedDTO {
    private Long tripId;
    private Long enterpriseId;
    private Long driverId;
    private Long vehicleId;
    private String departureLocation;
    private String arrivalLocation;
    private String departureLabel;
    private String arrivalLabel;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String pngRoute;

    public TripResponseCreatedDTO(Trips trip) {
        this.tripId = trip.getTripId();
        this.enterpriseId = trip.getEnterpriseId().getId();
        this.driverId = trip.getDriverId().getId();
        this.vehicleId = trip.getVehicleId().getId();
        this.departureLocation = trip.getDepartureLocation();
        this.arrivalLocation = trip.getArrivalLocation();
        this.departureLabel = trip.getDepartureLabel();
        this.arrivalLabel = trip.getArrivalLabel();
        this.departureTime = trip.getDepartureTime();
        this.arrivalTime = trip.getArrivalTime();
        this.pngRoute = trip.getPngRoute();
    }

    public String getArrivalLabel() {
        return arrivalLabel;
    }

    public void setArrivalLabel(String arrivalLabel) {
        this.arrivalLabel = arrivalLabel;
    }

    public String getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getDepartureLabel() {
        return departureLabel;
    }

    public void setDepartureLabel(String departureLabel) {
        this.departureLabel = departureLabel;
    }

    public String getDepartureLocation() {
        return departureLocation;
    }

    public void setDepartureLocation(String departureLocation) {
        this.departureLocation = departureLocation;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getPngRoute() {
        return pngRoute;
    }

    public void setPngRoute(String pngRoute) {
        this.pngRoute = pngRoute;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}

