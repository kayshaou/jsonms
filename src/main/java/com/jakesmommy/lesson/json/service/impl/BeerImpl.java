package com.jakesmommy.lesson.json.service.impl;

import com.jakesmommy.lesson.json.domain.Beer;
import com.jakesmommy.lesson.json.service.Alcohol;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BeerImpl implements Alcohol {

    @Override
    public Beer saveAlcohol() {
        return Beer.builder()
                .id(UUID.randomUUID())
                .beerName("ABC")
                .quantity(30)
                .beerStyle("XYZ")
                .build();
    }

    @Override
    public Beer getAlcohol(UUID id) {
        return Beer.builder()
                .id(UUID.randomUUID())
                .beerName("ABC")
                .quantity(30)
                .beerStyle("XYZ")
                .build();
    }
}
