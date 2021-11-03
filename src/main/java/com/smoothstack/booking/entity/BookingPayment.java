package com.smoothstack.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "booking_payment")
public class BookingPayment {

	@Id
	@Column(name = "booking_id")
	private int bookingId;
	
	@Column(name = "stripe_id")
	private String stripeId;
	
	@Column(name = "refunded")
	private int refund;
	
	public BookingPayment() {}
	
	public BookingPayment(int bookingId, String stripeId, int refund) {
		this.bookingId = bookingId;
		this.stripeId = stripeId;
		this.refund = refund;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBooking(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getStripeId() {
		return stripeId;
	}

	public void setStripeId(String stripeId) {
		this.stripeId = stripeId;
	}

	public int getRefund() {
		return refund;
	}

	public void setRefund(int refund) {
		this.refund = refund;
	}
}
