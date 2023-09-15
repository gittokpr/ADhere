package com.hashcoders.adhere.customer.controller;

import com.hashcoders.adhere.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;
}
