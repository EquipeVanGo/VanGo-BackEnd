package com.monqui.van_go.services.interfaces;

import com.monqui.van_go.dto.passenger.PassengerRequestDTO;
import com.monqui.van_go.dto.passenger.PassengerResponseLoginDTO;

public interface PassengerInterface {

    PassengerResponseLoginDTO login(PassengerRequestDTO passengerRequestDTO);


}
