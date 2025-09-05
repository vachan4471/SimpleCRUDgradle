package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Introspected
public class BookResponseDto {
    private long bookId;
    private String title;
    private String author;
    private double price;
}
