package com.hashcoders.adhere.listing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListingResponse {
    private String listingName;
    private Long hostId;
    private String location;
    private String dimension;
    private String format;
    private String listingType;
    private String status;
    private String description;
}
