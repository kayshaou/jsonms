package com.jakesmommy.lesson.json.service;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public interface Alcohol<T> {
    public T saveAlcohol();
    public T getAlcohol(UUID id);

}
