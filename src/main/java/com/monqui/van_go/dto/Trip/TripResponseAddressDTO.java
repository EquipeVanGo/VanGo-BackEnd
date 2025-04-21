package com.monqui.van_go.dto.Trip;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripResponseAddressDTO {

    private Long id;
    private String label;
    private String streetAddress;
    private String postalCode;
    private String number;
    private String complement;
}
