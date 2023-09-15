package com.hashcoders.adhere.listing.controller;

import com.hashcoders.adhere.booking.entity.Booking;
import com.hashcoders.adhere.listing.dto.ListingRequest;
import com.hashcoders.adhere.listing.dto.ListingResponse;
import com.hashcoders.adhere.listing.entity.Listing;
import com.hashcoders.adhere.listing.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping()
    public List<Listing> getListingsByAHost(@RequestParam String hostId) {
        return listingService.getListingsByAHost(hostId);
    }
}
