package com.example.question2.controller;

import com.example.question2.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class AvailabilityController {

    @Autowired
    private AvailabilityService availabilityService;

    @GetMapping("/getAvailability")
    public String getAvailability(@RequestParam(name = "productId") String productId){
        try {
            return availabilityService.getAvailabilityProduct(productId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
