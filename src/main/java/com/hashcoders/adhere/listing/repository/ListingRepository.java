package com.hashcoders.adhere.listing.repository;

import com.hashcoders.adhere.listing.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByHostId(Long hostId);
}
