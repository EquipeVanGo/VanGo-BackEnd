package com.monqui.van_go.dto.Trip;


import com.monqui.van_go.entities.Driver;
import com.monqui.van_go.entities.Enterprise;
import com.monqui.van_go.entities.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripRequestCreateDTO {

    private Long tripId;
    private Enterprise enterpriseId;
    private Driver driver;
    private Vehicle vehicle;
    private String departureLocation;
    private String departureTime;
    private String arrivalLocation;
    private String arrivalTime;
}
