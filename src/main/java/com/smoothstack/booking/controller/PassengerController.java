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

import com.smoothstack.booking.entity.Passenger;
import com.smoothstack.booking.exception.IdMismatchException;
import com.smoothstack.booking.exception.IdNotFoundException;
import com.smoothstack.booking.service.PassengerService;

@RestController
@RequestMapping(path = "/passenger")
public class PassengerController {

	@Autowired
	private PassengerService service;
	
	public PassengerController(PassengerService service) {
		
		this.service = service;
	}
	
	//Create
	@PostMapping("/add")
	public ResponseEntity<Passenger> addPassenger(@RequestBody Passenger passenger) {
		service.save(passenger);
		return ResponseEntity.ok(passenger);
	}
	
	//Read
	@GetMapping("/all")
	public ResponseEntity<List<Passenger>> readAllPassengers() {
		
		List<Passenger> passengers = service.readAll();
		if(passengers.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(passengers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Passenger> readPassengerById(@PathVariable int id) {
		
		Passenger passenger = service.readById(id).orElseThrow(IdNotFoundException::new);
		return ResponseEntity.ok(passenger);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updatePassenger(@PathVariable int id, @RequestBody Passenger passenger) {
		
		//Check if path id = user id
		if(id != passenger.getId()) {
			throw new IdMismatchException();
		}
		//Check if the record to update exists
		Passenger temp = service.readById(id).orElseThrow(IdNotFoundException::new);
		service.save(passenger);
		return ResponseEntity.ok("Passenger updated successfully");
	}
	
	//Delete
	@DeleteMapping("/delete{id}")
	public ResponseEntity<Void> deletePassenger(@PathVariable int id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
