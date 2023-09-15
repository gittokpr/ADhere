package com.hashcoders.adhere.booking.repository;

import com.hashcoders.adhere.booking.entity.Booking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByListingId(Long id);
}
