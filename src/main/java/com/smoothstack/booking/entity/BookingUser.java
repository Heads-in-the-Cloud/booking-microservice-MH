package com.smoothstack.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_user")
public class BookingUser {

	@Id
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column(name = "user_id")
	private int userId;
	
	public BookingUser() {}
	
	public BookingUser(int bookingId, int userId) {
		this.bookingId = bookingId;
		this.userId = userId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
