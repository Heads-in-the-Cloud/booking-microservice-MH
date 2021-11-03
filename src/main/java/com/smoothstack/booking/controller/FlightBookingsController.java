package com.smoothstack.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.booking.entity.FlightBookings;
import com.smoothstack.booking.exception.IdMismatchException;
import com.smoothstack.booking.exception.IdNotFoundException;
import com.smoothstack.booking.service.FlightBookingsService;

@RestController
@RequestMapping(path = "/flightbooking")
public class FlightBookingsController {

	@Autowired
	private FlightBookingsService service;
	
	public FlightBookingsController(FlightBookingsService service) {
		
		this.service = service;
	}
	
	//Create
	@PostMapping
	public ResponseEntity<FlightBookings> addFlightBookings(@RequestBody FlightBookings flightBookings) {
		service.save(flightBookings);
		return ResponseEntity.ok(flightBookings);
	}
	
	//Read
	@GetMapping
	public ResponseEntity<List<FlightBookings>> readAllFlightBookingss() {
		
		List<FlightBookings> flightBookings = service.readAll();
		if(flightBookings.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(flightBookings);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FlightBookings> readFlightBookingsById(@PathVariable int id) {
		
		FlightBookings flightBookings = service.readById(id).orElseThrow(IdNotFoundException::new);
		return ResponseEntity.ok(flightBookings);
	}
	
	//Update
	@PutMapping("/{id}")
	public ResponseEntity<String> updateFlightBookings(@PathVariable int id, @RequestBody FlightBookings flightBookings) {
		
		if(id != flightBookings.getBookingId()) {
			throw new IdMismatchException();
		}
		service.save(flightBookings);
		return ResponseEntity.ok("FlightBookings updated successfully");
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteFlightBookings(@PathVariable int id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
