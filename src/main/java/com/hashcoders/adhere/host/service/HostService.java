package com.hashcoders.adhere.host.service;

import com.hashcoders.adhere.host.entity.Host;
import com.hashcoders.adhere.host.entity.dto.HostDetail;
import com.hashcoders.adhere.host.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;

    public Host getReferenceById(final Long hostId) {
        return hostRepository.getReferenceById(hostId);
    }

    public HostDetail getHostDetail(final long id) {
        Host host = hostRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));

        return HostDetail.builder()
                .name(host.getName())
                .mail(host.getMail())
                .phoneNumber(host.getPhoneNumber())
                .address(host.getAddress())
                .build();
    }
}
