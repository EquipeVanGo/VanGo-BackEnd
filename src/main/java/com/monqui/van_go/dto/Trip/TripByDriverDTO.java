package com.monqui.van_go.dto.Trip;

import java.time.LocalDateTime;
import java.util.List;

public class TripByDriverDTO {
    private Long tripId;
    private Long enterpriseId;
    private Long driverId;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<PassengerSimpleDTO> passengers;

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
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

    public List<PassengerSimpleDTO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerSimpleDTO> passengers) {
        this.passengers = passengers;
    }

    public Long getTripId() {
        return tripId;
    }

    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public static class PassengerSimpleDTO {
        private Long id;
        private String name;
        private String departureLabel;
        private String arrivalLabel;

        public PassengerSimpleDTO(Long id, String name, String departureLabel, String arrivalLabel) {
            this.id = id;
            this.name = name;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
