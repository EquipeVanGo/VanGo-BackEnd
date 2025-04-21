package com.monqui.van_go.dto.driver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DriverRequestDTO {

    private Long id;
    private String name;
    private String phone;
    private String licenseNumber;

    public DriverRequestDTO(Long id, String name) {
    }
}
