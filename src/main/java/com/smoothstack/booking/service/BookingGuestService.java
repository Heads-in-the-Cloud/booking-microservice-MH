package com.smoothstack.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.booking.dao.BookingGuestDAO;
import com.smoothstack.booking.entity.BookingGuest;

@Service
public class BookingGuestService {

	@Autowired
	private BookingGuestDAO dao;
	
	public BookingGuestService(BookingGuestDAO dao) {
		this.dao = dao;
	}
	
	public List<BookingGuest> readAll() {
		
		List<BookingGuest> bookingGuests = new ArrayList<BookingGuest>();
		dao.findAll().forEach(bookingGuest -> bookingGuests.add(bookingGuest));
		return bookingGuests;
	}
	
	public Optional<BookingGuest> readById(int id) {
		
		return dao.findById(id);
	}
	
	public void save(BookingGuest bookingGuest) {
		
		dao.save(bookingGuest);
	}
	
	public void delete(int id) {
		
		dao.findById(id).ifPresent(dao::delete);
	}
}
