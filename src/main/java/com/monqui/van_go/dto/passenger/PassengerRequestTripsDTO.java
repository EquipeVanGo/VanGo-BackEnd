package com.monqui.van_go.dto.passenger;

public class PassengerRequestTripsDTO {

    private Long tripId;
    private Long passengerId;
    private String firstName;
    private String departureLabel;
    private String arrivalLabel;

    public PassengerRequestTripsDTO() {

    }

    public PassengerRequestTripsDTO(Long tripId, Long id, String firstName,
                                    String departureLabel, String arrivalLabel) {
        this.tripId = tripId;
        this.passengerId = id;
        this.firstName = firstName;
        this.departureLabel = departureLabel;
        this.arrivalLabel = arrivalLabel;
    }
    public Long getTripId() {
        return tripId;
    }
    public void setTripId(Long tripId) {
        this.tripId = tripId;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public java.lang.String getDepartureLabel() {
        return departureLabel;
    }

    public void setDepartureLabel(String departureLabel) {
        this.departureLabel = departureLabel;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getArrivalLabel() {
        return arrivalLabel;
    }
    public void setArrivalLabel(String arrivalLabel) {
        this.arrivalLabel = arrivalLabel;
    }
}
