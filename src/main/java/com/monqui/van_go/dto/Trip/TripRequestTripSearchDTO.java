package com.monqui.van_go.dto.Trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripRequestTripSearchDTO {
    private String departureLocation;
    private String arrivalLocation;
}
