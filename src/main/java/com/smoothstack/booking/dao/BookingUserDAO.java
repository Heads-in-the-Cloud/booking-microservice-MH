package com.smoothstack.booking.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smoothstack.booking.entity.BookingUser;

@Repository
public interface BookingUserDAO extends JpaRepository<BookingUser, Integer> {

}
