package com.hashcoders.adhere.booking.service;

import com.hashcoders.adhere.booking.entity.Booking;
import com.hashcoders.adhere.booking.repository.BookingRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<Booking> findByListingId(final Long id) {
        return bookingRepository.findByListingId(id);
    }
}
