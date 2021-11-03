package com.smoothstack.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_guest")
public class BookingGuest {

	@Id
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column(name = "contact_email")
	private String email;
	
	@Column(name = "contact_phone")
	private String phone;
	
	public BookingGuest() {}
	
	public BookingGuest(int bookingId, String email, String phone) {
		this.bookingId = bookingId;
		this.email = email;
		this.phone = phone;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
}
