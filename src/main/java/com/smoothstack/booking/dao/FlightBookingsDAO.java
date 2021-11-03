package com.smoothstack.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.booking.entity.FlightBookings;

@Repository
public interface FlightBookingsDAO extends JpaRepository<FlightBookings, Integer> {

}
