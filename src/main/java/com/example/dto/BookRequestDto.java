package com.example.dto;

import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Introspected // this is used to tell we are doing Json serialization/deserialization, validation.
public class BookRequestDto {
    @NotBlank(message = "Book title is needed")
    private String title;

    @NotBlank(message = "Book author is needed")
    private String author;

    @NotNull(message = "Book price must required")
    @Min(value = 1,message = "Price must be positive")
    private double price;
}
