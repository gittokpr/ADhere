package com.hashcoders.adhere.payment.service;

import com.hashcoders.adhere.payment.repository.PaymentRepository;
import com.hashcoders.adhere.payment.repository.dto.HostPaymentHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public HostPaymentHistory getHostPaymentHistory(final Long hostId){
       return paymentRepository.getHostPaymentHistory(hostId);
    }

}
