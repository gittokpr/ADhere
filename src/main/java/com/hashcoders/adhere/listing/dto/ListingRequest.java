package com.hashcoders.adhere.listing.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListingRequest {
    private String type;
    private Long hostId;
    private String name;
    private String location;
    private String dimensions;
    private String description;
    private String format;
}
