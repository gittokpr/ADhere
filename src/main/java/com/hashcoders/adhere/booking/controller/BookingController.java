package com.hashcoders.adhere.booking.controller;

import com.hashcoders.adhere.booking.dto.BookingResponse;
import com.hashcoders.adhere.booking.dto.CreateBooking;
import com.hashcoders.adhere.booking.dto.CreateReservation;
import com.hashcoders.adhere.booking.dto.ReviewBookingRequest;
import com.hashcoders.adhere.booking.entity.Booking;
import com.hashcoders.adhere.booking.service.BookingService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public List<BookingResponse> createBookings(@RequestBody List<CreateBooking> createBookingList) {
        return bookingService.createBookings(createBookingList);
    }

    @PostMapping("/reserve")
    public List<BookingResponse> createReservation(@RequestBody List<CreateReservation> createReservationList) {
        return bookingService.createReservation(createReservationList);
    }

    @PostMapping("/review")
    public BookingResponse reviewBooking(@RequestBody ReviewBookingRequest reviewBookingRequest) {
        return bookingService.reviewBooking(reviewBookingRequest);
    }
}
