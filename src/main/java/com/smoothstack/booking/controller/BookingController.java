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

import com.smoothstack.booking.entity.Booking;
import com.smoothstack.booking.exception.IdMismatchException;
import com.smoothstack.booking.exception.IdNotFoundException;
import com.smoothstack.booking.service.BookingService;

@RestController
@RequestMapping(path = "/booking")
public class BookingController {

	@Autowired
	private BookingService service;
	
	public BookingController(BookingService service) {
		
		this.service = service;
	}
	
	//Create
	@PostMapping
	public ResponseEntity<Booking> addBooking(@RequestBody Booking booking) {
		service.save(booking);
		return ResponseEntity.ok(booking);
	}
	
	//Read
	@GetMapping
	public ResponseEntity<List<Booking>> readAllBookings() {
		
		List<Booking> bookings = service.readAll();
		if(bookings.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(bookings);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Booking> readBookingById(@PathVariable int id) {
		
		Booking booking = service.readById(id).orElseThrow(IdNotFoundException::new);
		return ResponseEntity.ok(booking);
	}
	
	//Update
	@PutMapping("/{id}")
	public ResponseEntity<String> updateBooking(@PathVariable int id, @RequestBody Booking booking) {
		
		if(id != booking.getId()) {
			throw new IdMismatchException();
		}
		service.save(booking);
		return ResponseEntity.ok("Booking updated successfully");
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBooking(@PathVariable int id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
