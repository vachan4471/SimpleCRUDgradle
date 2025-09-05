package com.example.repository;

import com.example.entity.Book;
import io.micronaut.data.annotation.Repository;
import io.micronaut.data.jpa.repository.JpaRepository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
