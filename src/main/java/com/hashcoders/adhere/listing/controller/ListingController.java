package com.hashcoders.adhere.listing.controller;

import com.hashcoders.adhere.listing.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/listing")
@RequiredArgsConstructor
public class ListingController {
    private final ListingService listingService;
}
