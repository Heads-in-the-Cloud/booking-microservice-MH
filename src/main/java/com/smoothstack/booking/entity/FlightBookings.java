package com.smoothstack.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight_bookings")
public class FlightBookings {

	@Id
	@Column(name = "flight_id")
	private int flightId;
	
	@Column(name = "booking_id")
	private int bookingId;
	
	public FlightBookings() {}
	
	public FlightBookings(int flightId, int bookingId) {
		this.flightId = flightId;
		this.bookingId = bookingId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
}
