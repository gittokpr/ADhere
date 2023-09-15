package com.hashcoders.adhere.listingavailability.service;

import com.hashcoders.adhere.listing.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListingAvailabilityService {
    private final ListingRepository listingRepository;
}
