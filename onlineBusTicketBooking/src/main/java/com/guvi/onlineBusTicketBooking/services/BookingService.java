package com.guvi.onlineBusTicketBooking.services;

import com.guvi.onlineBusTicketBooking.dto.BookingDto;

import java.util.List;

public interface BookingService {
    BookingDto createBooking(BookingDto bookingDto);

    BookingDto getBookingById(Long bookingId);

    List<BookingDto> getAllBookings();

    BookingDto updateBookings(Long bookingId ,BookingDto updatedBooking);

    void deleteBooking(Long BookingId);
}
