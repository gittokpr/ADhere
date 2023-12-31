package com.hashcoders.adhere.payment.service;

import com.hashcoders.adhere.payment.repository.PaymentRepository;
import com.hashcoders.adhere.payment.repository.dto.HostPaymentHistory;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public BigDecimal getTotalInvestmentByCustomerAndStatus(final Long id, final String status) {
        return paymentRepository.getTotalInvestmentByCustomerAndStatus(id, status);
    }

    public HostPaymentHistory getHostPaymentHistory(final Long hostId){
       return paymentRepository.getHostPaymentHistory(hostId);
    }

}
