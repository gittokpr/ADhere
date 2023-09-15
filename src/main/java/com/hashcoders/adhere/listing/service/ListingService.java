package com.hashcoders.adhere.listing.service;

import com.hashcoders.adhere.host.entity.Host;
import com.hashcoders.adhere.host.service.HostService;
import com.hashcoders.adhere.listing.dto.ListingRequest;
import com.hashcoders.adhere.listing.dto.ListingResponse;
import com.hashcoders.adhere.listing.entity.Listing;
import com.hashcoders.adhere.listing.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ListingService {
    private final ListingRepository listingRepository;
    private final HostService hostService;

    public ListingResponse createListing(final ListingRequest listingRequest) {
        Host host = hostService.getHostById(listingRequest.getHostId());
        Listing listing = new Listing();
        listing.setListingName(listingRequest.getName());
        listing.setHost(host);
        listing.setLocation(listingRequest.getLocation());
        listing.setDimension(listingRequest.getDimensions());
        listing.setFormat(listingRequest.getFormat());
        listing.setListingType(listingRequest.getType());
        listing.setStatus("ACTIVE");
        listing.setDescription(listingRequest.getDescription());
        final Listing listingEntity = listingRepository.save(listing);
        return ListingResponse.builder()
                .listingName(listingEntity.getListingName())
                .hostId(listingEntity.getHost().getId())
                .location(listingEntity.getLocation())
                .dimension(listingEntity.getDimension())
                .format(listingEntity.getFormat())
                .listingType(listingEntity.getListingType())
                .status(listingEntity.getStatus())
                .description(listingEntity.getDescription())
                .build();
    }

    public ListingResponse getListingById(final Long id) {
        Listing listing = listingRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return ListingResponse.builder()
                .listingName(listing.getListingName())
                .hostId(listing.getHost().getId())
                .location(listing.getLocation())
                .dimension(listing.getDimension())
                .format(listing.getFormat())
                .listingType(listing.getListingType())
                .status(listing.getStatus())
                .description(listing.getDescription())
                .build();
    }
}
