package com.guvi.onlineBusTicketBooking.mapper;

import com.guvi.onlineBusTicketBooking.dto.BusDto;
import com.guvi.onlineBusTicketBooking.entities.Bus;

public class BusMapper {

    public static BusDto mapToBusDto(Bus bus) {
        return new BusDto(
                bus.getId(),
                bus.getBusName(),
                bus.getCapacity(),
                bus.getFromLocation(),
                bus.getToLocation()
//                bus.getDepartureTime(),
        );
    }

    public static Bus mapToBus(BusDto busDto) {
        return new Bus(
                busDto.getId(),
                busDto.getBusName(),
                busDto.getCapacity(),
                busDto.getFromLocation(),
                busDto.getToLocation()
//                busDto.getDepartureTime(),
        );
    }
}
