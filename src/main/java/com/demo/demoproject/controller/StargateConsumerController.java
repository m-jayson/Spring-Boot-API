package com.demo.demoproject.controller;

import com.demo.demoproject.service.StargateConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*")
public class StargateConsumerController {

    @Autowired
    StargateConsumerService stargateConsumerService;

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok(this.stargateConsumerService.printHelloWorld());
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> helloName(@PathVariable("name") String name){
        return ResponseEntity.ok(this.stargateConsumerService.printHelloWorldName(name));
    }
}
