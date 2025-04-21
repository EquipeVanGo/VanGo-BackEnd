package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.dto.passenger.PassengerRequestCreateDTO;
import com.monqui.van_go.dto.vehicle.VehicleRequestDTO;
import com.monqui.van_go.dto.address.AddressRequestDTO;
import com.monqui.van_go.dto.driver.DriverRequestDTO;
import com.monqui.van_go.dto.passenger.PassengerRequestDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TripResponseGenericDTO {
    private Long tripId;
    private Long enterpriseId;
    private String pngRoute;
    private DriverRequestDTO driver;
    private VehicleRequestDTO vehicle;
    private Integer availableSeats;
    private String destination;
    private String departureTime;
    private String departureLocation;
    private String arrivalLocation;
    private String estimatedArrivalTime;
    private String departureLabel;
    private String arrivalLabel;
    private List<PassengerRequestCreateDTO> passengers;
    private List<AddressRequestDTO> addresses;
}

