package com.hashcoders.adhere.listing.controller;

import com.hashcoders.adhere.booking.entity.Booking;
import com.hashcoders.adhere.listing.dto.ListingDetails;
import com.hashcoders.adhere.listing.dto.ListingRequest;
import com.hashcoders.adhere.listing.dto.ListingResponse;
import com.hashcoders.adhere.listing.service.ListingService;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/listing")
@RequiredArgsConstructor
public class ListingController {
    private final ListingService listingService;

    @PostMapping
    public ListingResponse createListing(@RequestBody ListingRequest listingRequest) {
        return listingService.createListing(listingRequest);
    }

    @GetMapping("/{id}")
    public ListingResponse getListingById(@PathVariable final Long id) {
        return listingService.getListingById(id);
    }

    @GetMapping("/{id}/bookings")
    public List<Booking> getAllBookingForId(@PathVariable Long id) {
        return listingService.getAllBookingsForId(id);
    }

    @GetMapping
    public List<ListingDetails> getAllListing(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime startTime,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime endTime
    ) {
        return listingService.getAllListing(location, startTime, endTime);
    }
}
