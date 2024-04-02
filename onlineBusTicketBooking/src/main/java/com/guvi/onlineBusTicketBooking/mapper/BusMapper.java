package com.guvi.onlineBusTicketBooking.mapper;

import com.guvi.onlineBusTicketBooking.dto.BusDto;
import com.guvi.onlineBusTicketBooking.entities.Bus;

public class BusMapper {

    public static BusDto mapToBusDto(Bus bus) {
        return new BusDto(
                bus.getId(),
                bus.getBusName(),
                bus.getDoj(),
                bus.getFromLocation(),
                bus.getToLocation(),
                bus.getPrice(),
                bus.getSeats(),
                bus.getAvailableSeats()

        );
    }

    public static Bus mapToBus(BusDto busDto) {
        return new Bus(
                busDto.getId(),
                busDto.getBusName(),
                busDto.getDoj(),
                busDto.getFromLocation(),
                busDto.getToLocation(),
                busDto.getPrice(),
                busDto.getSeats(),
                busDto.getAvailableSeats()
        );
    }
}
