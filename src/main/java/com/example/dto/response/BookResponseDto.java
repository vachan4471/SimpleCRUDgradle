package com.example.dto.response;

import io.micronaut.core.annotation.Introspected;

@Introspected
public record BookResponseDto (
    long bookId,
    String title,
    String author,
    double price
){}
