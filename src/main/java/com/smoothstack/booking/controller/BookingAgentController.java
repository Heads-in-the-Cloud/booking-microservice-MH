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

import com.smoothstack.booking.entity.BookingAgent;
import com.smoothstack.booking.exception.IdMismatchException;
import com.smoothstack.booking.exception.IdNotFoundException;
import com.smoothstack.booking.service.BookingAgentService;

@RestController
@RequestMapping(path = "/agent")
public class BookingAgentController {

	@Autowired
	private BookingAgentService service;
	
	public BookingAgentController(BookingAgentService service) {
		
		this.service = service;
	}
	
	//Create
	@PostMapping
	public ResponseEntity<BookingAgent> addBookingAgent(@RequestBody BookingAgent bookingAgent) {
		service.save(bookingAgent);
		return ResponseEntity.ok(bookingAgent);
	}
	
	//Read
	@GetMapping
	public ResponseEntity<List<BookingAgent>> readAllBookingAgents() {
		
		List<BookingAgent> bookingAgents = service.readAll();
		if(bookingAgents.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(bookingAgents);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookingAgent> readBookingAgentById(@PathVariable int id) {
		
		BookingAgent bookingAgent = service.readById(id).orElseThrow(IdNotFoundException::new);
		return ResponseEntity.ok(bookingAgent);
	}
	
	//Update
	@PutMapping("/{id}")
	public ResponseEntity<String> updateBookingAgent(@PathVariable int id, @RequestBody BookingAgent bookingAgent) {
		
		if(id != bookingAgent.getUserId()) {
			throw new IdMismatchException();
		}
		service.save(bookingAgent);
		return ResponseEntity.ok("BookingAgent updated successfully");
	}
	
	//Delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBookingAgent(@PathVariable int id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
