package com.monqui.van_go.dto.vehicle;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequestDTO {
    private Long id;
    private String model;
    private String plate;
    private Integer seats;

    public VehicleRequestDTO(Long id, String model, String plate, Integer quantityPlaces, String color) {
    }
}
