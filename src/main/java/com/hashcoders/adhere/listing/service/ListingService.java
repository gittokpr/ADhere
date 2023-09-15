package com.hashcoders.adhere.listing.service;

import com.hashcoders.adhere.booking.entity.Booking;
import com.hashcoders.adhere.booking.service.BookingService;
import com.hashcoders.adhere.listing.dto.ListingRequest;
import com.hashcoders.adhere.listing.dto.ListingResponse;
import com.hashcoders.adhere.listing.entity.Listing;
import com.hashcoders.adhere.listing.repository.ListingRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
    private final BookingService bookingService;

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

    public ListingResponse getListingById(final Long id) {
        Listing listing = listingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return ListingResponse.builder()
                .listingName(listing.getListingName())
                .host(listing.getHost())
                .location(listing.getLocation())
                .dimension(listing.getDimension())
                .format(listing.getFormat())
                .listingType(listing.getListingType())
                .status(listing.getStatus())
                .description(listing.getDescription())
                .build();
    }

    public List<Booking> getAllBookingsForId(final Long id) {
        return bookingService.findByListingId(id);
    }
}
