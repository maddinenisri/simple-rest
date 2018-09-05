package com.mdstech.sample.service;

import com.mdstech.sample.vo.Car;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RateCalculator {
    private Map<String, Double> rateSheet = new HashMap<>();

    public RateCalculator() {}

    @PostConstruct
    public void init() {
        rateSheet.put("Honda_Accord", 3.05d);
        rateSheet.put("Honda_Civic", 2.55d);
        rateSheet.put("Honda_Odyssey", 4.95d);
        rateSheet.put("Honda_Pilot", 5.15d);

        rateSheet.put("GM_Bolt", 3.05d);
        rateSheet.put("GM_Impala", 5.05d);
        rateSheet.put("GM_Cadilac", 6.25d);
        rateSheet.put("GM_Buick", 4.35d);

        rateSheet.put("Toyota_Camry", 3.65d);
        rateSheet.put("Toyota_Carola", 2.55d);
        rateSheet.put("Toyota_Highlander", 5.15d);
        rateSheet.put("Toyota_Sienna", 4.55d);
    }


    public List<Car> getRate(List<Car> cars) {
        List<Car> updatedCars =  cars.stream().map(c -> {
            c.setRating(rateSheet.get(String.format("%s_%s", c.getManufacturer(), c.getModel())));
            return c;
        }
        ).collect(Collectors.toList());
        return updatedCars;
    }

}
