package com.guvi.onlineBusTicketBooking.dto;

import com.guvi.onlineBusTicketBooking.entities.Bus;
import com.guvi.onlineBusTicketBooking.entities.Passenger;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String bookingId;
    private String bookingDate;
    private Passenger passenger;
    private Bus bus;
    private String busName;
    private int fee;
    private LocalDate departureDate;


}
