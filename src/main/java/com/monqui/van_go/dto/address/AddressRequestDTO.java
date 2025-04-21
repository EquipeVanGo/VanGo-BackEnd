package com.monqui.van_go.dto.address;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressRequestDTO {
    private Long passengerId; // pode ser null se for "destination"
    private String type; // "pickup" ou "destination"
    private String address;
    private Double latitude;
    private Double longitude;
    private String estimatedPickupTime; // pode ser null se for "destination"

    public AddressRequestDTO(Long id, String label, String street, String postalCode) {
    }
}
