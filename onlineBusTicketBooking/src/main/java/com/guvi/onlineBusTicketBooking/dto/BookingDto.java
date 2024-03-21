package com.guvi.onlineBusTicketBooking.dto;

import com.guvi.onlineBusTicketBooking.entities.Bus;
import com.guvi.onlineBusTicketBooking.entities.Passenger;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long busNumber;
    private Bus bus;
    private Passenger passenger;
    private String fromLocation;
    private String toLocation;
    private String firstname;
    private String LastName;
    private double totalPrice;

    public BookingDto(Long id, Bus bus, Long busNumber, Passenger passenger, String firstname, String lastName, String fromLocation, String toLocation, double totalPrice) {
    }

}
