package com.example.service;

import com.example.dto.BookMapperClass;
import com.example.dto.BookRequestDto;
import com.example.dto.BookResponseDto;
import com.example.entity.Book;
import com.example.repository.BookRepository;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepo;
    private final BookMapperClass bookMapper;

    public BookResponseDto addBook(BookRequestDto requestDto){
        Book savedBook = bookRepo.save(bookMapper.toEntity(requestDto));
        return bookMapper.toResponse(savedBook);
    }

    public List<BookResponseDto> getAllBooks(){
        return bookRepo.findAll().stream()
                .filter(Objects::nonNull)
                .map(bookMapper::toResponse)
                .toList();
    }

    public BookResponseDto getBookById(long bookId){
        Book savedBook = bookRepo.findById(bookId).orElseThrow(
                ()->new EntityNotFoundException("Book with id:"+bookId+" Not Found")
        );
        return bookMapper.toResponse(savedBook);
    }

    public BookResponseDto updateBookById(long bookId, BookRequestDto requestDto){
        Optional<Book> savedBook = bookRepo.findById(bookId);
        if(savedBook.isEmpty()){
            throw new EntityNotFoundException("Book with id"+bookId+" Not Found");
        }
        Book updateBook = savedBook.get();
        bookMapper.updateEntityFromDto(requestDto,updateBook);
        return bookMapper.toResponse(bookRepo.save(updateBook));
    }

    public void deleteBookById(long bookId){
        if(!bookRepo.existsById(bookId)){
            throw new EntityNotFoundException("Book with id:"+bookId+" Not Found");
        }
        bookRepo.deleteById(bookId);
    }
}
