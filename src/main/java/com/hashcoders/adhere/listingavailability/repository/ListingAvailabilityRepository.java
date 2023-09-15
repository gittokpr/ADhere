package com.hashcoders.adhere.listingavailability.repository;

import com.hashcoders.adhere.listingavailability.entity.ListingAvailability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListingAvailabilityRepository extends JpaRepository<ListingAvailability, Long> {
}
