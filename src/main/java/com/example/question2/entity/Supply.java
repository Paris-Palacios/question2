package com.example.question2.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class Supply {
    private String productId;
    private Double quantity;

    public static List<Supply> getSupply(){

        Supply supply1 =Supply.builder()
                .productId("Product1")
                .quantity(10.0)
                .build();

        Supply supply2 =Supply.builder()
                .productId("Product2")
                .quantity(5.0)
                .build();

        return List.of(supply1, supply2);
    }
}
