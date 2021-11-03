package com.smoothstack.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.booking.entity.BookingGuest;

@Repository
public interface BookingGuestDAO extends JpaRepository<BookingGuest, Integer> {

}
