package com.guvi.onlineBusTicketBooking.mapper;

import com.guvi.onlineBusTicketBooking.dto.BusDto;
import com.guvi.onlineBusTicketBooking.entities.Bus;

public class BusMapper {

    public static BusDto mapToBusDto(Bus bus) {
        return new BusDto(
                bus.getId(),
                bus.getBusNumber(),
                bus.getCapacity());
    }

    public static Bus mapToBus(BusDto busDto) {
        return new Bus(
                busDto.getId(),
                busDto.getBusNumber(),
                busDto.getCapacity());
    }
}
