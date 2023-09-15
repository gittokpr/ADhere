package com.hashcoders.adhere.payment.controller;

import com.hashcoders.adhere.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/payments")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
}
