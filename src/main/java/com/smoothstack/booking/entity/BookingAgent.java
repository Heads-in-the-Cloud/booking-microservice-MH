package com.smoothstack.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_agent")
public class BookingAgent {

	@Id
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column(name = "agent_id")
	private int userId;
	
	public BookingAgent() {}
	
	public BookingAgent(int bookingId, int userId) {
		this.bookingId = bookingId;
		this.userId = userId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBooking(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
