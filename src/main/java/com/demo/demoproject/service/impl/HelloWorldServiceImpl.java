package com.demo.demoproject.service.impl;

import com.demo.demoproject.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

    @Override
    public String printHelloWorld() {
        return "Hello World";
    }

    @Override
    public String printHelloWorldName(String name) {
        return "Hello," + name;
    }
}
