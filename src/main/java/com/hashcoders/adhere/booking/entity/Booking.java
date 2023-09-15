package com.hashcoders.adhere.booking.entity;

import com.hashcoders.adhere.customer.entity.Customer;
import com.hashcoders.adhere.host.entity.Host;
import com.hashcoders.adhere.listing.entity.Listing;
import com.hashcoders.adhere.payment.entity.Payment;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class Booking {
    private Long id;
    @ManyToOne
    @JoinColumn(name = "listing_id", referencedColumnName = "id")
    private Listing listing;
    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    private Host host;
    private BigDecimal rate;
    private String status;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private String asset;
    private OffsetDateTime startTime;
    private OffsetDateTime endTime;
    @ManyToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private Payment payment;
}
