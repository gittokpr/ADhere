package com.hashcoders.adhere.booking.repository;

import com.hashcoders.adhere.booking.entity.Booking;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByListingId(Long id);

    @Query(nativeQuery = true, value = "SELECT count(*) from booking where customer_id = :id and status = :status")
    Long getActiveCustomerBookingsByIdAndStatus(Long id, String status);
}
