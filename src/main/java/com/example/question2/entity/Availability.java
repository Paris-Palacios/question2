package com.example.question2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Availability {
    private String productId;
    private Double Availability;
}
