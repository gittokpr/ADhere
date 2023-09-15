package com.hashcoders.adhere.booking.service;

import com.hashcoders.adhere.booking.dto.BookingResponse;
import com.hashcoders.adhere.booking.dto.CreateBooking;
import com.hashcoders.adhere.booking.dto.CreateReservation;
import com.hashcoders.adhere.booking.dto.ReviewBookingRequest;
import com.hashcoders.adhere.booking.entity.Booking;
import com.hashcoders.adhere.booking.repository.BookingRepository;
import com.hashcoders.adhere.customer.repository.CustomerRepository;
import com.hashcoders.adhere.customer.service.CustomerService;
import com.hashcoders.adhere.host.service.HostService;
import com.hashcoders.adhere.listing.service.ListingService;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final ListingService listingService;
    private final HostService hostService;
    private final CustomerRepository customerRepository;

    public List<BookingResponse> createBookings(final List<CreateBooking> createBookingList) {
        final List<Booking> bookingList = createBookingList.stream()
                .map(bookingRequest -> {
                    Booking booking = new Booking();
                    booking.setListing(listingService.getReferenceById(bookingRequest.getListingId()));
                    booking.setHost(hostService.getReferenceById(bookingRequest.getHostId()));
                    booking.setRate(bookingRequest.getRate());
                    booking.setStatus("ACTIVE");
                    booking.setStartTime(bookingRequest.getStartTime());
                    booking.setEndTime(bookingRequest.getEndTime());
                    return booking;
                })
                .collect(Collectors.toList());
        final List<Booking> bookings = bookingRepository.saveAll(bookingList);
        return bookings.stream()
                .map(BookingService::getBookingResponse)
                .collect(Collectors.toList());
    }

    public List<BookingResponse> createReservation(final List<CreateReservation> createReservationList) {
        final List<Booking> bookingList = createReservationList.stream()
                .map(reserveRequest -> {
                    Optional<Booking> bookingOptional = bookingRepository.findById(reserveRequest.getBookingId());
                    if (bookingOptional.isPresent()) {
                        Booking booking = bookingOptional.get();
                        booking.setCustomer(customerRepository.getReferenceById(reserveRequest.getCustomerId()));
                        booking.setStatus("REVIEW_IN_PROGRESS");
                        booking.setAsset(reserveRequest.getAsset());
                        return booking;
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        final List<Booking> bookings = bookingRepository.saveAll(bookingList);
        return bookings.stream()
                .map(BookingService::getBookingResponse)
                .collect(Collectors.toList());
    }

    private static BookingResponse getBookingResponse(final Booking booking) {
        BookingResponse bookingResponse = new BookingResponse();
        bookingResponse.setBookingId(booking.getId());
        bookingResponse.setListingId(booking.getListing().getId());
        bookingResponse.setHostId(booking.getHost().getId());
        if (Objects.nonNull(booking.getCustomer())) {
            bookingResponse.setCustomerId(booking.getCustomer().getId());
        }
        if (Objects.nonNull(booking.getPayment())) {
            bookingResponse.setPaymentId(booking.getPayment().getId());
        }
        bookingResponse.setRate(booking.getRate());
        bookingResponse.setStatus(booking.getStatus());
        bookingResponse.setAsset(booking.getAsset());
        bookingResponse.setStartTime(booking.getStartTime());
        bookingResponse.setEndTime(booking.getEndTime());
        return bookingResponse;
    }

    public BookingResponse reviewBooking(final ReviewBookingRequest reviewBookingRequest) {
        final Optional<Booking> bookingOptional = bookingRepository.findById(reviewBookingRequest.getBookingId());
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            if (booking.getStatus().equalsIgnoreCase("IN_REVIEW")) {
                if (reviewBookingRequest.getReviewStatus().equalsIgnoreCase("ACCEPT")) {
                    booking.setStatus("BOOKED");
                } else {
                    booking.setStatus("ACTIVE");
                }
            }
            final Booking bookingFinal = bookingRepository.save(booking);
            return getBookingResponse(bookingFinal);
        }
        return null;
    }

    public Long getActiveBookingByCustomerIdAndStatus(final Long id, final String status) {
        return bookingRepository.getActiveCustomerBookingsByIdAndStatus(id, status);
    }
}
