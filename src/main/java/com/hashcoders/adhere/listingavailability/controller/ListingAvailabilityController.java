package com.hashcoders.adhere.listingavailability.controller;

import com.hashcoders.adhere.listingavailability.service.ListingAvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/listing/availability")
@RequiredArgsConstructor
public class ListingAvailabilityController {
    private final ListingAvailabilityService listingAvailabilityService;
}
