package com.guvi.onlineBusTicketBooking.services.impl;

import com.guvi.onlineBusTicketBooking.dto.BookingDto;
import com.guvi.onlineBusTicketBooking.entities.Booking;
import com.guvi.onlineBusTicketBooking.exception.ResourceNotFoundException;
import com.guvi.onlineBusTicketBooking.mapper.BookingMapper;
import com.guvi.onlineBusTicketBooking.repos.BookingRepo;
import com.guvi.onlineBusTicketBooking.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    private BookingRepo bookingRepo;

    @Override
    public BookingDto createBooking(BookingDto bookingDto) {

        Booking booking = BookingMapper.mapToBooking(bookingDto);
        Booking savedBooking = bookingRepo.save(booking);

        return BookingMapper.mapToBookingDto(savedBooking);
    }

    @Override
    public BookingDto getBookingById(Long bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Booking not exists with the given id " + bookingId));
        return BookingMapper.mapToBookingDto(booking);
    }

    @Override
    public List<BookingDto> getAllBookings() {
        List<Booking> bookings = bookingRepo.findAll();
        return bookings.stream().map(BookingMapper::mapToBookingDto).collect(Collectors.toList());
    }

    @Override
    public BookingDto updateBookings(Long bookingId, BookingDto updatedBooking) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() ->new ResourceNotFoundException(
                        "Bookings with the given id is not exists " + bookingId));
        booking.setBus(updatedBooking.getBus());
        booking.setBusNumber(updatedBooking.getBusNumber());
        booking.setPassenger(updatedBooking.getPassenger());
        booking.setFirstname(updatedBooking.getFirstname());
        booking.setLastName(updatedBooking.getLastName());
        booking.setFromLocation(updatedBooking.getFromLocation());
        booking.setToLocation(updatedBooking.getToLocation());
        booking.setTotalPrice(updatedBooking.getTotalPrice());

        Booking updatedBookingObj = bookingRepo.save(booking);
        return BookingMapper.mapToBookingDto(updatedBookingObj);
    }

    @Override
    public void deleteBooking(Long bookingId) {

        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() ->new ResourceNotFoundException(
                        "Bookings with the given id is not exists " + bookingId));
        bookingRepo.deleteById(bookingId);
    }
}

