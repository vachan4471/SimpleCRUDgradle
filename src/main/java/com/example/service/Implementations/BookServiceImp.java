package com.example.service.Implementations;

import com.example.dto.mapper.BookMapperClass;
import com.example.dto.request.BookRequestDto;
import com.example.dto.response.BookResponseDto;
import com.example.entity.Book;
import com.example.repository.BookRepository;
import com.example.service.interfaces.BookService;
import jakarta.inject.Singleton;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Singleton
@RequiredArgsConstructor
public class BookServiceImp implements BookService {

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
        return bookMapper.toResponse(bookRepo.update(updateBook));
    }

    public void deleteBookById(long bookId){
        if(!bookRepo.existsById(bookId)){
            throw new EntityNotFoundException("Book with id:"+bookId+" Not Found");
        }
        bookRepo.deleteById(bookId);
    }
}
