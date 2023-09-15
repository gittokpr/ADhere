package com.hashcoders.adhere.host.entity.dto;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HostDetail {
    private String name;
    private String mail;
    private String phoneNumber;
    private String address;
    private BigDecimal totalRevenue;
    private Integer customerCount;
    private Integer totalCount;
}
