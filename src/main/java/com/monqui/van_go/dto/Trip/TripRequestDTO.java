package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.entity.enums.TripTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripRequestDTO {

    private Long idPassenger;
    private String departureLocation;
    private String arrivalLocation;
    private TripTypes tripTypes;

}
