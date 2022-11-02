package com.cf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cf.model.Booking;

public interface IBookingDao extends JpaRepository<Booking, Integer>
{

}
