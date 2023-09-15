package com.hashcoders.adhere.host.service;

import com.hashcoders.adhere.host.entity.Host;
import com.hashcoders.adhere.host.entity.dto.HostDetail;
import com.hashcoders.adhere.host.repository.HostRepository;
import com.hashcoders.adhere.payment.repository.dto.HostPaymentHistory;
import com.hashcoders.adhere.payment.service.PaymentService;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;
    private final PaymentService paymentService;

    public Host getReferenceById(final Long hostId) {
        return hostRepository.getReferenceById(hostId);
    }

    public HostDetail getHostDetail(final long id) {
        Host host = hostRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        HostPaymentHistory hostPaymentHistory = paymentService.getHostPaymentHistory(id);
        return buildHostDetail(host, hostPaymentHistory);
    }

    public HostDetail buildHostDetail(Host host, HostPaymentHistory hostPaymentHistory) {
        HostDetail hostDetail = new HostDetail();
        hostDetail.setName(host.getName());
        hostDetail.setMail(host.getMail());
        hostDetail.setPhoneNumber(host.getPhoneNumber());
        hostDetail.setAddress(host.getAddress());
        hostDetail.setTotalCount(hostPaymentHistory.getTotalCount());
        hostDetail.setCustomerCount(hostPaymentHistory.getCustomerCount());
        hostDetail.setTotalRevenue(
                ObjectUtils.isEmpty(hostPaymentHistory.getTotalRevenue()) ? BigDecimal.ZERO : hostPaymentHistory.getTotalRevenue());
        return hostDetail;
    }
}
