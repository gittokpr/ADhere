package com.hashcoders.adhere.listing.entity;

import com.hashcoders.adhere.host.entity.Host;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "listing")
@Data
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String listingName;
    @ManyToOne
    @JoinColumn(name = "host_id", referencedColumnName = "id")
    private Host host;
    private String location;
    private String dimension;
    private String format;
    private String listingType;
    private String status;
    private String description;
}
