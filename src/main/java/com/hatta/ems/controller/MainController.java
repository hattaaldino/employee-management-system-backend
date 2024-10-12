package com.hatta.ems.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping
    public ResponseEntity<String> testConnection(){
        return new ResponseEntity<String>(
                "API Connected",
                HttpStatus.OK
        );
    }

}
