package com.smoothstack.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.booking.dao.BookingAgentDAO;
import com.smoothstack.booking.entity.BookingAgent;

@Service
public class BookingAgentService {

	@Autowired
	private BookingAgentDAO dao;
	
	public BookingAgentService(BookingAgentDAO dao) {
		this.dao = dao;
	}
	
	public List<BookingAgent> readAll() {
		
		List<BookingAgent> bookingAgents = new ArrayList<BookingAgent>();
		dao.findAll().forEach(bookingAgent -> bookingAgents.add(bookingAgent));
		return bookingAgents;
	}
	
	public Optional<BookingAgent> readById(int id) {
		
		return dao.findById(id);
	}
	
	public void save(BookingAgent bookingAgent) {
		
		dao.save(bookingAgent);
	}
	
	public void delete(int id) {
		
		dao.findById(id).ifPresent(dao::delete);
	}
}
