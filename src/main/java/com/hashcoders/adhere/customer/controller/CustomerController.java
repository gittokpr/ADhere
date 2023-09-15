package com.hashcoders.adhere.customer.controller;

import com.hashcoders.adhere.customer.dto.CustomerDetailsResponse;
import com.hashcoders.adhere.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/details/{id}")
    public CustomerDetailsResponse getCustomerDetails(@PathVariable final Long id) {
        return customerService.getCustomerDetails(id);
    }
}
