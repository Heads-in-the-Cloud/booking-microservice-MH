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

import com.smoothstack.booking.entity.BookingUser;
import com.smoothstack.booking.exception.IdMismatchException;
import com.smoothstack.booking.exception.IdNotFoundException;
import com.smoothstack.booking.service.BookingUserService;

@RestController
@RequestMapping(path = "/user")
public class BookingUserController {

	@Autowired
	private BookingUserService service;
	
	public BookingUserController(BookingUserService service) {
		
		this.service = service;
	}
	
	//Create
	@PostMapping("/add")
	public ResponseEntity<BookingUser> addBookingUser(@RequestBody BookingUser bookingUser) {
		service.save(bookingUser);
		return ResponseEntity.ok(bookingUser);
	}
	
	//Read
	@GetMapping("/all")
	public ResponseEntity<List<BookingUser>> readAllBookingUsers() {
		
		List<BookingUser> bookingUsers = service.readAll();
		if(bookingUsers.isEmpty())
			return ResponseEntity.noContent().build();
		return ResponseEntity.ok(bookingUsers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<BookingUser> readBookingUserById(@PathVariable int id) {
		
		BookingUser bookingUser = service.readById(id).orElseThrow(IdNotFoundException::new);
		return ResponseEntity.ok(bookingUser);
	}
	
	//Update
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateBookingUser(@PathVariable int id, @RequestBody BookingUser bookingUser) {
		
		//Check if path id = id
		if(id != bookingUser.getBookingId())
			throw new IdMismatchException();
		//Check if the record to update exists
		BookingUser temp = service.readById(id).orElseThrow(IdNotFoundException::new);
		service.save(bookingUser);
		return ResponseEntity.ok("BookingUser updated successfully");
	}
	
	//Delete
	@DeleteMapping("/dalate/{id}")
	public ResponseEntity<Void> deleteBookingUser(@PathVariable int id) {
		
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
