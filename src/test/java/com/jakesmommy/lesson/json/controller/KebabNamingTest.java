package com.jakesmommy.lesson.json.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakesmommy.lesson.json.domain.Beer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.util.Objects;

@ActiveProfiles("snake")
@JsonTest
@Slf4j
public class KebabNamingTest {

    @Autowired
    ObjectMapper mapper;

    @Test
    public void testDeser() throws JsonProcessingException {
        String json = "{\"id\":null,\"beer_name\":\"BeerName\",\"beer_style\":\"BeerStyle\",\"upc\":2030303,\"quantity\":300}";
        Beer beer = mapper.readValue(json, Beer.class);
        assertNotNull(beer);
    }

    @Test
    public void testSer() throws JsonProcessingException {
        Beer beer = Beer.builder()
                .beerName("BeerName")
                .beerStyle("BeerStyle")
                .upc(2030303l)
                .quantity(300).build();

        log.info("beer "+mapper.writeValueAsString(beer));
        assertTrue(Objects.nonNull(mapper.writeValueAsString(beer)));
    }


}
