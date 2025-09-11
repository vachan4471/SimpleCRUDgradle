//we can create an app using cli command :- mn create-app <appName> -> serverless app.

package com.example.entity;

//import io.micronaut.data.annotation.MappedEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//@MappedEntity("books") //This is like @Entity+@Table(name="Book")
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String bookTitle;
    private String author;
    private double price;
    private boolean available=true;
}

