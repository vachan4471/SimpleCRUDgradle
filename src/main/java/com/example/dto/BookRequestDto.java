package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Introspected // this is used to tell we are doing Json serialization/deserialization, validation.
public record BookRequestDto(
    @NotBlank(message = "Book title is needed")
    String title,

    @NotBlank(message = "Book author is needed")
    String author,

    @Min(value = 1,message = "Price must be positive")
    double price
) {}
