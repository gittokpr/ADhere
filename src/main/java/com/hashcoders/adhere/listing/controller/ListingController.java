package com.hashcoders.adhere.listing.controller;

import com.hashcoders.adhere.booking.entity.Booking;
import com.hashcoders.adhere.listing.dto.ListingRequest;
import com.hashcoders.adhere.listing.dto.ListingResponse;
import com.hashcoders.adhere.listing.entity.Listing;
import com.hashcoders.adhere.listing.service.ListingService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

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

    @GetMapping("/host/{id}")
    public List<Listing> getListingsByAHost(@PathVariable String hostId) {
        return listingService.getListingsByAHost(hostId);
    }
}
