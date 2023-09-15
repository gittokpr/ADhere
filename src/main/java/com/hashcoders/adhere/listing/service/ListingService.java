package com.hashcoders.adhere.listing.service;

import com.hashcoders.adhere.booking.entity.Booking;
import com.hashcoders.adhere.booking.repository.BookingRepository;
import com.hashcoders.adhere.host.entity.Host;
import com.hashcoders.adhere.host.service.HostService;
import com.hashcoders.adhere.listing.dto.ListingDetails;
import com.hashcoders.adhere.listing.dto.ListingRequest;
import com.hashcoders.adhere.listing.dto.ListingResponse;
import com.hashcoders.adhere.listing.entity.Listing;
import com.hashcoders.adhere.listing.repository.ListingRepository;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ListingService {
    public static final String LISTING_STATUS_ACTIVE = "ACTIVE";
    public static final String BOOKING_STATUS_ACTIVE = "ACTIVE";
    private final ListingRepository listingRepository;
    private final HostService hostService;
    private final BookingRepository bookingRepository;

    public ListingResponse createListing(final ListingRequest listingRequest) {
        Host host = hostService.getReferenceById(listingRequest.getHostId());
        Listing listing = new Listing();
        listing.setListingName(listingRequest.getName());
        listing.setHost(host);
        listing.setLocation(listingRequest.getLocation());
        listing.setDimension(listingRequest.getDimensions());
        listing.setFormat(listingRequest.getFormat());
        listing.setListingType(listingRequest.getType());
        listing.setStatus(LISTING_STATUS_ACTIVE);
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

    public List<Booking> getAllBookingsForId(final Long id) {
        return bookingRepository.findByListingId(id);
    }

    public Listing getReferenceById(final Long listingId) {
        return listingRepository.getReferenceById(listingId);
    }

    public List<Listing> getListingsByAHost(Long hostId)  {
        return listingRepository.findByHostId(hostId);
    }

    public List<ListingDetails> getAllListing(String location, OffsetDateTime startTime, OffsetDateTime endTime) {
        if (StringUtils.isBlank(location)
                && Objects.isNull(startTime)
                && Objects.isNull(endTime)
        ) {
            return listingRepository.findAllByStatusAndBookingStatus(LISTING_STATUS_ACTIVE, BOOKING_STATUS_ACTIVE);
        } else if (StringUtils.isNotBlank(location) && Objects.nonNull(startTime)
                && Objects.nonNull(endTime)) {
            return listingRepository.findAllByDateLocationAndStatus(location, startTime,
                    endTime, LISTING_STATUS_ACTIVE, BOOKING_STATUS_ACTIVE);
        }
        else if (StringUtils.isNotBlank(location)) {
            return listingRepository.findAllByLocationAndStatusAndBookingStatus(location, LISTING_STATUS_ACTIVE, BOOKING_STATUS_ACTIVE);
        } else {
            return listingRepository.findAllByDateAndStatus(startTime,
                    endTime, LISTING_STATUS_ACTIVE, BOOKING_STATUS_ACTIVE);
        }
    }
}
