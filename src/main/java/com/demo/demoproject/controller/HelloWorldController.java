package com.demo.demoproject.controller;

import com.demo.demoproject.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
@CrossOrigin(origins = "*")
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;

    @GetMapping
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok(this.helloWorldService.printHelloWorld());
    }

    @GetMapping("/{name}")
    public ResponseEntity<String> helloName(@PathVariable("name") String name){
        return ResponseEntity.ok(this.helloWorldService.printHelloWorldName(name));
    }
}
