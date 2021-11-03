package com.smoothstack.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.booking.dao.FlightBookingsDAO;
import com.smoothstack.booking.entity.FlightBookings;

@Service
public class FlightBookingsService {

	@Autowired
	private FlightBookingsDAO dao;
	
	public FlightBookingsService(FlightBookingsDAO dao) {
		this.dao = dao;
	}
	
	public List<FlightBookings> readAll() {
		
		List<FlightBookings> flightBookings = new ArrayList<FlightBookings>();
		dao.findAll().forEach(flightBooking -> flightBookings.add(flightBooking));
		return flightBookings;
	}
	
	public Optional<FlightBookings> readById(int id) {
		
		return dao.findById(id);
	}
	
	public void save(FlightBookings flightBookings) {
		
		dao.save(flightBookings);
	}
	
	public void delete(int id) {
		
		dao.findById(id).ifPresent(dao::delete);
	}
}
