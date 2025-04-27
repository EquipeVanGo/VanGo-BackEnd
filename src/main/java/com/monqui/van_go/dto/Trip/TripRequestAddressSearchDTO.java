package com.monqui.van_go.dto.Trip;

import com.monqui.van_go.entities.enums.TripTypes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripRequestAddressSearchDTO {
    private Long idPassenger;
    private String partialAddress; // O endereço parcial que o usuário está digitando
    private TripTypes tripType;
}
