package com.smoothstack.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.booking.entity.Passenger;

@Repository
public interface PassengerDAO extends JpaRepository<Passenger, Integer> {

}
