package com.hashcoders.adhere.host.service;

import com.hashcoders.adhere.host.repository.HostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;
}
