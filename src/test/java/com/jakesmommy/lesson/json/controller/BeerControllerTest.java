package com.jakesmommy.lesson.json.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jakesmommy.lesson.json.constant.BeerConstants;
import com.jakesmommy.lesson.json.domain.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.servlet.ServletContext;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.actuate.metrics.web.servlet.WebMvcTags.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeer() throws Exception {
        mockMvc.perform(get(BeerConstants.V1+"/"+ UUID.randomUUID()))
                        .andExpect(status().isOk());
    }

    @Test
    void addBeer() throws Exception {
        Beer beer = Beer.builder()
                .beerName("BeerName")
                .beerStyle("BeerStyle")
                .upc(2030303l)
                .quantity(300).build();
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post(BeerConstants.V1)
                .content(objectMapper.writeValueAsString(beer))
                        .contentType(MediaType.APPLICATION_JSON);
        ResultMatcher resultMatcher = MockMvcResultMatchers.status().isCreated();
        mockMvc.perform(requestBuilder).andExpect(resultMatcher);
    }
}