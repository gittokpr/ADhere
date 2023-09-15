package com.hashcoders.adhere.listing.service;

import com.hashcoders.adhere.listing.dto.ListingRequest;
import com.hashcoders.adhere.listing.entity.Listing;
import com.hashcoders.adhere.listing.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;

    public Listing createListing(final ListingRequest listingRequest) {
        Listing listing = new Listing();
        listing.setListingName(listingRequest.getName());
        listing.setLocation(listingRequest.getLocation());
        listing.setDimension(listingRequest.getDimensions());
        listing.setFormat(listingRequest.getFormat());
        listing.setListingType(listingRequest.getType());
        listing.setStatus("ACTIVE");
        return listingRepository.save(listing);
    }
}
