package com.jakesmommy.lesson.json.controller;

import com.jakesmommy.lesson.json.constant.BeerConstants;
import com.jakesmommy.lesson.json.domain.Beer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jakesmommy.lesson.json.service.Alcohol;
import com.jakesmommy.lesson.json.service.impl.BeerImpl;

import java.util.UUID;

@RequestMapping(BeerConstants.V1)
@RestController
@Slf4j
public class BeerController {

    @Autowired
    private Alcohol alcohol;

    BeerController(BeerImpl beer) {
        this.alcohol = beer;
    }

    @GetMapping("/{beerId}")
    public ResponseEntity<Alcohol> getBeer(@PathVariable(value = "beerId") UUID beerId){
        Beer beer = (Beer) alcohol.getAlcohol(beerId);
        return new ResponseEntity(beer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity addBeer(@RequestBody @Validated Beer beer){
        return new ResponseEntity(beer, HttpStatus.CREATED);
    }
}
