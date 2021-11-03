package com.smoothstack.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.booking.entity.BookingPayment;

@Repository
public interface BookingPaymentDAO extends JpaRepository<BookingPayment, Integer> {

}
