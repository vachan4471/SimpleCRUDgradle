package com.example.controller;

import com.example.dto.BookRequestDto;
import com.example.dto.BookResponseDto;
import com.example.service.BookService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.List;


@Controller("api/v1/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @Post
        public HttpResponse<BookResponseDto> addBook(@Valid @Body BookRequestDto requestDto){
            BookResponseDto responseDto = bookService.addBook(requestDto);
            return HttpResponse.created(responseDto);
        }

    @Get("/")
        public HttpResponse<List<BookResponseDto>> getAllBook(){
            List<BookResponseDto> responseDtos = bookService.getAllBooks();
            return HttpResponse.ok(responseDtos);
        }

    @Get("/{bookId}")
        public HttpResponse<BookResponseDto> getBookById(@PathVariable long bookId){
            BookResponseDto responseDto = bookService.getBookById(bookId);
            return HttpResponse.ok(responseDto);
        }

    @Put("/{bookId}")
        public HttpResponse<BookResponseDto> updateBookById(@Body BookRequestDto requestDto, @PathVariable long bookId){
            BookResponseDto responseDto = bookService.updateBookById(bookId,requestDto);
            return HttpResponse.ok(responseDto);
        }

    @Delete("/{bookId}")
        public HttpResponse<String> deleteBookById(@PathVariable long bookId){
            bookService.deleteBookById(bookId);
            return HttpResponse.ok("Book deleted with id:"+bookId+" !");
        }

}
