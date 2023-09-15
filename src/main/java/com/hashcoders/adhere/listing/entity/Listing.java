package com.hashcoders.adhere.listing.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "listing")
@Data
public class Listing {
    private Long id;
    private String listingName;
    private String location;
    private String dimension;
    private String format;
    private String listingType;
    private String status;
    private String description;
}
