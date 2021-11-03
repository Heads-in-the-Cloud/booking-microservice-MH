package com.smoothstack.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.booking.dao.PassengerDAO;
import com.smoothstack.booking.entity.Passenger;

@Service
public class PassengerService {

	@Autowired
	private PassengerDAO dao;
	
	public PassengerService(PassengerDAO dao) {
		this.dao = dao;
	}
	
	public List<Passenger> readAll() {
		
		List<Passenger> passengers = new ArrayList<Passenger>();
		dao.findAll().forEach(passenger -> passengers.add(passenger));
		return passengers;
	}
	
	public Optional<Passenger> readById(int id) {
		
		return dao.findById(id);
	}
	
	public void save(Passenger passenger) {
		
		dao.save(passenger);
	}
	
	public void delete(int id) {
		
		dao.findById(id).ifPresent(dao::delete);
	}
}
