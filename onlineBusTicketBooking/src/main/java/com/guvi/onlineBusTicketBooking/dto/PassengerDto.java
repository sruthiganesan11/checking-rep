package com.guvi.onlineBusTicketBooking.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Passenger")
@Entity
public class PassengerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String aadharId;
    private int contactNo;
    private String email;
    private int age;
    private String journeyStat;
    private String cancelStat;

}