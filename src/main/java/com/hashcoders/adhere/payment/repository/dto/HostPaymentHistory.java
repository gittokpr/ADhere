package com.hashcoders.adhere.payment.repository.dto;

import java.math.BigDecimal;

public interface HostPaymentHistory {
    BigDecimal getTotalRevenue();
    Integer getCustomerCount();
    Integer getTotalCount();
}
