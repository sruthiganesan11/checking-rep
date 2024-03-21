package com.guvi.onlineBusTicketBooking.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "booking")
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long busNumber;
    @ManyToOne
    private Bus bus;
    @ManyToOne
    private Passenger passenger;
    private String fromLocation;
    private String toLocation;
    private String firstname;
    private String LastName;
    private double totalPrice;

    public Booking(Long id, Bus bus, Long busNumber, Passenger passenger, String firstname,
                   String lastName, String fromLocation, String toLocation, double totalPrice) {
    }
}