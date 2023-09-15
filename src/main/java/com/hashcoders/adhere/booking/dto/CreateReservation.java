package com.hashcoders.adhere.booking.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateReservation {
    private Long bookingId;
    private Long customerId;
    private String asset;
}
