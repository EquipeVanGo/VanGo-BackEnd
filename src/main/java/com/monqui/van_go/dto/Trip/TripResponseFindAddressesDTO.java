package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.entities.Trips;
import java.time.LocalDateTime;

public class TripResponseFindAddressesDTO {

    private String departureLocation;
    private String departureLabel;

    public TripResponseFindAddressesDTO(Trips trip) {
        this.departureLocation = trip.getDepartureLocation();
        this.departureLabel = trip.getDepartureLabel();
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
}

