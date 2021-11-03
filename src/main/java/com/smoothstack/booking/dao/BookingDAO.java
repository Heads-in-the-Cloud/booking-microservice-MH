package com.smoothstack.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.booking.entity.Booking;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Integer>{

}
