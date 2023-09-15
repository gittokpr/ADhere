package com.hashcoders.adhere.customer.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDetailsResponse {
    private String name;
    private String mail;
    private String phoneNumber;
    private String address;
    private Long activeBookings;
    private BigDecimal totalInvestments;
}
