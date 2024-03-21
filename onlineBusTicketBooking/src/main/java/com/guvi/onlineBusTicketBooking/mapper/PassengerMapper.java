package com.guvi.onlineBusTicketBooking.mapper;

import com.guvi.onlineBusTicketBooking.dto.PassengerDto;
import com.guvi.onlineBusTicketBooking.entities.Passenger;

public class PassengerMapper {

    public static PassengerDto mapToPassengerDto(Passenger passenger) {
        return new PassengerDto(
                passenger.getId(),
                passenger.getFirstname(),
                passenger.getLastName(),
                passenger.getPhoneNumber(),
                passenger.getEmail());
    }

    public static Passenger mapToPassenger(PassengerDto passengerDto) {
        return new Passenger(
                passengerDto.getId(),
                passengerDto.getFirstname(),
                passengerDto.getLastName(),
                passengerDto.getPhoneNumber(),
                passengerDto.getEmail());
    }

}
