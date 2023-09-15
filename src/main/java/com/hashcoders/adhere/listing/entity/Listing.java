package com.hashcoders.adhere.listing.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "listing")
@Data
public class Listing {
    private Long id;
}
