package com.hashcoders.adhere.listing.controller;

import com.hashcoders.adhere.listing.dto.ListingRequest;
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
    public Listing createListing(@RequestBody ListingRequest listingRequest) {
        return listingService.createListing(listingRequest);
    }

    @GetMapping()
    public List<Listing> getListingsByAHost(@RequestParam String hostId) {
        return listingService.getListingsByAHost(hostId);
    }
}
