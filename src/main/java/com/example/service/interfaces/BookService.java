package com.example.service.interfaces;

import com.example.dto.request.BookRequestDto;
import com.example.dto.response.BookResponseDto;

import java.util.List;

public interface BookService {
    BookResponseDto addBook(BookRequestDto requestDto);
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(long bookId);
    BookResponseDto updateBookById(long bookId, BookRequestDto requestDto);
    void deleteBookById(long bookId);
}
