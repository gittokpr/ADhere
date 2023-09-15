package com.hashcoders.adhere.listing.dto;

import com.hashcoders.adhere.host.entity.Host;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListingResponse {
    private String listingName;
    private Host host;
    private String location;
    private String dimension;
    private String format;
    private String listingType;
    private String status;
    private String description;
}
