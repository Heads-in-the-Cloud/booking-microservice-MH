package com.smoothstack.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.booking.dao.BookingUserDAO;
import com.smoothstack.booking.entity.BookingUser;

@Service
public class BookingUserService {

	@Autowired
	private BookingUserDAO dao;
	
	public BookingUserService(BookingUserDAO dao) {
		this.dao = dao;
	}
	
	public List<BookingUser> readAll() {
		
		List<BookingUser> bookingUsers = new ArrayList<BookingUser>();
		dao.findAll().forEach(bookingUser -> bookingUsers.add(bookingUser));
		return bookingUsers;
	}
	
	public Optional<BookingUser> readById(int id) {
		
		return dao.findById(id);
	}
	
	public void save(BookingUser bookingUser) {
		
		dao.save(bookingUser);
	}
	
	public void delete(int id) {
		
		dao.findById(id).ifPresent(dao::delete);
	}
}
