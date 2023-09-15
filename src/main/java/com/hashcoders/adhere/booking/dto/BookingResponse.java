package com.hashcoders.adhere.booking.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private Long bookingId;
    private Long listingId;
    private Long HostId;
    private Long customerId;
    private Long paymentId;
    private BigDecimal rate;
    private String status;
    private String asset;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
}
