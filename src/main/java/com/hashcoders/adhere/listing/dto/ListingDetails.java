package com.hashcoders.adhere.listing.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface ListingDetails {
    Long getBookingId();
    Long getListingId();
    BigDecimal getRate();
    LocalDateTime getStartTime();
    LocalDateTime getEndTime();
    String getListingName();
    String getLocation();
    String getDimension();
    String getFormat();
    String getListingType();
    String getDescription();
}
