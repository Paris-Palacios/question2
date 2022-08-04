package com.example.question2.service;

import com.example.question2.entity.Availability;
import com.example.question2.entity.Demand;
import com.example.question2.entity.Supply;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AvailabilityService {

    public String getAvailabilityProduct(String productId){
        Double demand = getDemandById(productId);
        Double supply = getSupplydById(productId);
        Double availability = getAvailability(supply,demand);

        if(availability.equals(0.0)){
            return "204 No Content";
        }
        else {
            Availability availabilityObject = new Availability(productId,availability);
            Gson gson = new Gson();
            return gson.toJson(availabilityObject);
        }
    }

    public Double getAvailability(Double supply, Double demand){
        double availability = supply - demand;
        if (availability>0){
            return  availability;
        }
            else {
            return 0.0;
        }
    }

    public Double getDemandById(String productId){
      Demand demand =  Demand.getDemand().stream()
                .filter(d -> d.getProductId().equalsIgnoreCase(productId))
                .limit(1)
                .findFirst()
                .orElseThrow();

        return demand.getQuantity();
    }

    public Double getSupplydById(String productId){
        Supply supply =  Supply.getSupply().stream()
                .filter(s -> s.getProductId().equalsIgnoreCase(productId))
                .limit(1)
                .findFirst()
                .orElseThrow();

        return supply.getQuantity();
    }
}
