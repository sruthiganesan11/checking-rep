package com.guvi.onlineBusTicketBooking.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private Long id;

    private String firstName;

    private String lastName;

    private String aadharId;

    private String contactNo;

    private String email;

    private int age;

    private boolean journeyStat;

    private boolean cancelStat;

}