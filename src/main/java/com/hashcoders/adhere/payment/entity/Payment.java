package com.hashcoders.adhere.payment.entity;

import com.hashcoders.adhere.customer.entity.Customer;
import com.hashcoders.adhere.host.entity.Host;
import com.hashcoders.adhere.listing.entity.Listing;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    private Host host;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "listing_id", referencedColumnName = "id")
    private Listing listing;
    private BigDecimal amount;
    private String status;
    private String platformFee;
}
