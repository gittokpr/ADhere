package com.hashcoders.adhere.booking.controller;

import com.hashcoders.adhere.booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
}
