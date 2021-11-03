package com.smoothstack.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.booking.dao.BookingDAO;
import com.smoothstack.booking.entity.Booking;

@Service
public class BookingService {

	@Autowired
	private BookingDAO dao;
	
	public BookingService(BookingDAO dao) {
		this.dao = dao;
	}
	
	public List<Booking> readAll() {
		
		List<Booking> bookings = new ArrayList<Booking>();
		dao.findAll().forEach(booking -> bookings.add(booking));
		return bookings;
	}
	
	public Optional<Booking> readById(int id) {
		
		return dao.findById(id);
	}
	
	public void save(Booking booking) {
		
		dao.save(booking);
	}
	
	public void delete(int id) {
		
		dao.findById(id).ifPresent(dao::delete);
	}
}
