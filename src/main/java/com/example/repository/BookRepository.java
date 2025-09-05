package com.example.repository;

import com.example.entity.Book;
import io.micronaut.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
