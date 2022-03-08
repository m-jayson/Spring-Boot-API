package com.demo.demoproject.service.impl;

import com.demo.demoproject.service.StargateConsumerService;
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
