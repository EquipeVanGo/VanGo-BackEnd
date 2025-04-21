package com.monqui.van_go.dto.passenger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerResponseLoginDTO {

    private Long id;
    private String name;
    private String email;

}
