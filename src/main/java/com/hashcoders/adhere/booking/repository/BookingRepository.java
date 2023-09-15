package com.hashcoders.adhere.booking.repository;

import com.hashcoders.adhere.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
