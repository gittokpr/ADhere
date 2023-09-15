package com.hashcoders.adhere.customer.service;

import com.hashcoders.adhere.booking.service.BookingService;
import com.hashcoders.adhere.customer.dto.CustomerDetailsResponse;
import com.hashcoders.adhere.customer.entity.Customer;
import com.hashcoders.adhere.customer.repository.CustomerRepository;
import com.hashcoders.adhere.listing.entity.Listing;
import com.hashcoders.adhere.payment.service.PaymentService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private static final String BOOKED = "BOOKED";
    private static final String PAYMENT_STATUS_SUCCESS = "SUCCESS";
    private final CustomerRepository customerRepository;
    private final BookingService bookingService;
    private final PaymentService paymentService;

    public CustomerDetailsResponse getCustomerDetails(final Long id) {

        Long activeCustomerBookings = bookingService.getActiveBookingByCustomerIdAndStatus(id, BOOKED);
        BigDecimal totalInvestment = paymentService.getTotalInvestmentByCustomerAndStatus(id, PAYMENT_STATUS_SUCCESS);
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        return CustomerDetailsResponse.builder()
                .name(customer.getName())
                .mail(customer.getMail())
                .phoneNumber(customer.getPhoneNumber())
                .address(customer.getAddress())
                .activeBookings(activeCustomerBookings)
                .totalInvestments(totalInvestment)
                .build();
    }

    public Customer getReferenceById(final Long customerId) {
        return customerRepository.getReferenceById(customerId);
    }
}
