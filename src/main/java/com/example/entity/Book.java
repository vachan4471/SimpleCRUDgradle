//we can create an app using cli command :- mn create-app <appName> -> serverless app.

package com.example.entity;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.Column;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@MappedEntity("Book") //This is like @Entity+@Table(name="Book")
public class Book {
    @Id
    @GeneratedValue(GeneratedValue.Type.IDENTITY)
    private long bookId;
    private String bookTitle;
    private String author;
    private double price;

}

