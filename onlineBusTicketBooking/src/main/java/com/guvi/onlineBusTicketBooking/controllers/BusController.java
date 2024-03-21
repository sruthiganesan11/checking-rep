package com.guvi.onlineBusTicketBooking.controllers;
import com.guvi.onlineBusTicketBooking.dto.BusDto;
import com.guvi.onlineBusTicketBooking.services.BusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/buses")
public class BusController {

    private BusService busService;

    @PostMapping
    public ResponseEntity<BusDto> createBus(@RequestBody BusDto busDto) {
        BusDto savedBus = busService.createBus(busDto);
        return new ResponseEntity<>(savedBus, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<BusDto> getBusById(@PathVariable("id") Long busId) {
        BusDto busById = busService.getBusById(busId);
        return ResponseEntity.ok(busById);
    }

    @GetMapping
    public ResponseEntity<List<BusDto>> getAllBuses() {
        List<BusDto> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

    @PutMapping("{id}")
    public ResponseEntity<BusDto> updateBus(@PathVariable("id") Long busId ,
                                            @RequestBody BusDto updatedBus) {
        BusDto busDto = busService.updateBus(busId,updatedBus);
        return  ResponseEntity.ok(busDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBus(@PathVariable("id") Long busId) {
        busService.deleteBus(busId);
        return ResponseEntity.ok("Bus deleted successfully!");
    }
}