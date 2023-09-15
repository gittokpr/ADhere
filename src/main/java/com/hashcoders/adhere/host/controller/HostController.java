package com.hashcoders.adhere.host.controller;

import com.hashcoders.adhere.host.service.HostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/host")
@RequiredArgsConstructor
public class HostController {
    private final HostService hostService;
}
