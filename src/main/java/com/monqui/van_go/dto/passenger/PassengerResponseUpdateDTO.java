package com.monqui.van_go.dto.passenger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengerResponseUpdateDTO {

    private Long id;
    private String age;
    private String name;
    private String email;
    private String telephone;
}

//Irei implementar correções dos métodos posteriormente para diminuir acoplamento
