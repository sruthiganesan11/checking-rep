package com.guvi.onlineBusTicketBooking.services.impl;

import com.guvi.onlineBusTicketBooking.dto.PassengerDto;
import com.guvi.onlineBusTicketBooking.entities.Passenger;
import com.guvi.onlineBusTicketBooking.exception.ResourceNotFoundException;
import com.guvi.onlineBusTicketBooking.mapper.PassengerMapper;
import com.guvi.onlineBusTicketBooking.repos.PassengerRepo;
import com.guvi.onlineBusTicketBooking.services.PassengerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private PassengerRepo passengerRepo;

    @Override
    public PassengerDto createPassenger(PassengerDto passengerDto) {

        Passenger passenger = PassengerMapper.mapToPassenger(passengerDto);
        Passenger savedPassenger = passengerRepo.save(passenger);
        return PassengerMapper.mapToPassengerDto(savedPassenger);
    }

    @Override
    public PassengerDto getPassengerById(Long passengerId) {
        Passenger passenger = passengerRepo.findById(passengerId)
                .orElseThrow(() -> new ResourceNotFoundException
                        ("Passenger not exists with the given id " + passengerId));
        return PassengerMapper.mapToPassengerDto(passenger);
    }

    @Override
    public List<PassengerDto> getAllPassengers() {
        List<Passenger> passengers = passengerRepo.findAll();
        return passengers.stream().map(PassengerMapper::mapToPassengerDto).collect(Collectors.toList());
    }

    @Override
    public PassengerDto updatePassenger(Long passengerId, PassengerDto updatedPassenger) {

        Passenger passenger = passengerRepo.findById(passengerId).orElseThrow(
                () -> new ResourceNotFoundException("Passenger is not exists with the given id " + passengerId)
        );

        passenger.setFirstName(updatedPassenger.getFirstName());
        passenger.setLastName(updatedPassenger.getLastName());
        passenger.setAadharId(updatedPassenger.getAadharId());
        passenger.setContactNo(updatedPassenger.getContactNo());
        passenger.setEmail(updatedPassenger.getEmail());
        passenger.setAge(updatedPassenger.getAge());
        passenger.setJourneyStat(updatedPassenger.getJourneyStat());
        passenger.setCancelStat(updatedPassenger.getCancelStat());


        Passenger updatedPassengerObj = passengerRepo.save(passenger);

        return PassengerMapper.mapToPassengerDto(updatedPassengerObj);
    }

    @Override
    public void deletePassenger(Long passengerId) {

        Passenger passenger = passengerRepo.findById(passengerId).orElseThrow(
                () -> new ResourceNotFoundException("Passenger is not exists with the given id " + passengerId)
        );

        passengerRepo.deleteById(passengerId);
    }
}

