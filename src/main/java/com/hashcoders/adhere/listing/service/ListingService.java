package com.hashcoders.adhere.listing.service;

import com.hashcoders.adhere.listing.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
}
