package com.dsa.stargate.service.impl;

import com.dsa.stargate.service.StargateConsumerService;
import org.springframework.stereotype.Service;

@Service
public class StargateConsumerServiceImpl implements StargateConsumerService {

    @Override
    public String printHelloWorld() {
        return "Hello World";
    }

    @Override
    public String printHelloWorldName(String name) {
        return "Hello," + name;
    }
}
