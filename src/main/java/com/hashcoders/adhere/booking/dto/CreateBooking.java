package com.hashcoders.adhere.booking.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBooking {
    private Long listingId;
    private Long hostId;
    private BigDecimal rate;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
}
