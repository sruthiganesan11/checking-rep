package com.guvi.onlineBusTicketBooking.controllers;

import com.guvi.onlineBusTicketBooking.dto.PassengerDto;
import com.guvi.onlineBusTicketBooking.services.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private PassengerService passengerService;

    @PostMapping
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDto) {
        PassengerDto savedPassenger = passengerService.createPassenger(passengerDto);
        return new ResponseEntity<>(savedPassenger, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable("id") Long passengerId) {
        PassengerDto passengerById = passengerService.getPassengerById(passengerId);
        return ResponseEntity.ok(passengerById);
    }

    @GetMapping
    public ResponseEntity<List<PassengerDto>> getAllPassengers() {
        List<PassengerDto> passengers = passengerService.getAllPassengers();
        return ResponseEntity.ok(passengers);
    }

    @PutMapping("{id}")
    public ResponseEntity<PassengerDto> updatePassenger(@PathVariable("id") Long passengerId ,
                                            @RequestBody PassengerDto updatedPassenger) {
        PassengerDto passengerDto = passengerService.updatePassenger(passengerId,updatedPassenger);
        return  ResponseEntity.ok(passengerDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePassenger(@PathVariable("id") Long passengerId) {
        passengerService.deletePassenger(passengerId);
        return ResponseEntity.ok("Passenger deleted successfully!");
    }
}