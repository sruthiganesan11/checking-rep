package com.guvi.onlineBusTicketBooking.mapper;

import com.guvi.onlineBusTicketBooking.dto.BookingDto;
import com.guvi.onlineBusTicketBooking.entities.Booking;

public class BookingMapper {
    public static BookingDto mapToBookingDto(Booking booking) {
        return new BookingDto(
                booking.getId(),
                booking.getBus(),
                booking.getBusNumber(),
                booking.getPassenger(),
                booking.getFirstname(),
                booking.getLastName(),
                booking.getFromLocation(),
                booking.getToLocation(),
                booking.getTotalPrice()

        );
    }

    public static Booking mapToBooking(BookingDto bookingDto) {
        return new Booking(
                bookingDto.getId(),
                bookingDto.getBus(),
                bookingDto.getBusNumber(),
                bookingDto.getPassenger(),
                bookingDto.getFirstname(),
                bookingDto.getLastName(),
                bookingDto.getFromLocation(),
                bookingDto.getToLocation(),
                bookingDto.getTotalPrice()
        );
    }
}
