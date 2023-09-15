package com.hashcoders.adhere.listing.repository;

import com.hashcoders.adhere.listing.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
}
