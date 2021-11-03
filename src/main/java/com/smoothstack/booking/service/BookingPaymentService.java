package com.smoothstack.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smoothstack.booking.dao.BookingPaymentDAO;
import com.smoothstack.booking.entity.BookingPayment;

@Service
public class BookingPaymentService {

	@Autowired
	private BookingPaymentDAO dao;
	
	public BookingPaymentService(BookingPaymentDAO dao) {
		this.dao = dao;
	}
	
	public List<BookingPayment> readAll() {
		
		List<BookingPayment> bookingPayments = new ArrayList<BookingPayment>();
		dao.findAll().forEach(bookingPayment -> bookingPayments.add(bookingPayment));
		return bookingPayments;
	}
	
	public Optional<BookingPayment> readById(int id) {
		
		return dao.findById(id);
	}
	
	public void save(BookingPayment bookingPayment) {
		
		dao.save(bookingPayment);
	}
	
	public void delete(int id) {
		
		dao.findById(id).ifPresent(dao::delete);
	}
}
