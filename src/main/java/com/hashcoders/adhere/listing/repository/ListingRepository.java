package com.hashcoders.adhere.listing.repository;

import com.hashcoders.adhere.listing.dto.ListingDetails;
import com.hashcoders.adhere.listing.entity.Listing;
import java.time.OffsetDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByHostId(Long hostId);

    @Query(value = "select "
            + "b.id as bookingId, "
            + "l.id as listingId, "
            + "b.rate as rate, "
            + "b.start_time as startTime, "
            + "b.end_time as endTime, "
            + "l.listing_name as listingName, "
            + "l.location as location, "
            + "l.dimension as dimension, "
            + "l.format as format, "
            + "l.listing_type as listingType, "
            + "l.description as description "
            + "from booking b inner join listing l on b.listing_id = l.id "
            + "where l.status = :listingStatus and b.status = :bookingStatus", nativeQuery = true)
    List<ListingDetails> findAllByStatusAndBookingStatus(String listingStatus, String bookingStatus);

    @Query(value = "select "
            + "b.id as bookingId, "
            + "l.id as listingId, "
            + "b.rate as rate, "
            + "b.start_time as startTime, "
            + "b.end_time as endTime, "
            + "l.listing_name as listingName, "
            + "l.location as location, "
            + "l.dimension as dimension, "
            + "l.format as format, "
            + "l.listing_type as listingType, "
            + "l.description as description "
            + "from booking b inner join listing l on b.listing_id = l.id "
            + "where l.status = :listingStatus and b.status = :bookingStatus and l.location = :location", nativeQuery = true)
    List<ListingDetails> findAllByLocationAndStatusAndBookingStatus(String location, String listingStatus, String bookingStatus);

    @Query(value = "select "
            + "b.id as bookingId, "
            + "l.id as listingId, "
            + "b.rate as rate, "
            + "b.start_time as startTime, "
            + "b.end_time as endTime, "
            + "l.listing_name as listingName, "
            + "l.location as location, "
            + "l.dimension as dimension, "
            + "l.format as format, "
            + "l.listing_type as listingType, "
            + "l.description as description "
            + "from booking b inner join listing l on b.listing_id = l.id "
            + "where l.status = :listingStatus and b.status = :bookingStatus and b.start_time >= :startTime and b.end_time <= :endTime", nativeQuery = true)
    List<ListingDetails> findAllByDateAndStatus(OffsetDateTime startTime, OffsetDateTime endTime, String listingStatus, String bookingStatus);

    @Query(value = "select "
            + "b.id as bookingId, "
            + "l.id as listingId, "
            + "b.rate as rate, "
            + "b.start_time as startTime, "
            + "b.end_time as endTime, "
            + "l.listing_name as listingName, "
            + "l.location as location, "
            + "l.dimension as dimension, "
            + "l.format as format, "
            + "l.listing_type as listingType, "
            + "l.description as description "
            + "from booking b inner join listing l on b.listing_id = l.id "
            + "where l.status = :listingStatus and b.status = :bookingStatus and l.location = :location and b.start_time >= :startTime and b.end_time <= :endTime", nativeQuery = true)
    List<ListingDetails> findAllByDateLocationAndStatus(String location, OffsetDateTime startTime, OffsetDateTime endTime, String listingStatus, String bookingStatus);
}
