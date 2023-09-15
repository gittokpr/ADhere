package com.hashcoders.adhere.booking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewBookingRequest {
    private Long bookingId;
    private String reviewStatus;
}
