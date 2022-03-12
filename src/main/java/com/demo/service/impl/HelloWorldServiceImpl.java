package com.demo.service.impl;

import com.demo.service.HelloWorldService;
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
