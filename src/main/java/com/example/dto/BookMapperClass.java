package com.example.dto;

import com.example.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "jsr330") //will generate the implementation class as a JSR-330 compliant bean (using @Named annotation)
public interface BookMapperClass {
    @Mapping(source = "title", target = "bookTitle")
    Book toEntity(BookRequestDto requestDto);

    @Mapping(source = "bookTitle", target = "title")
    BookResponseDto toResponse(Book book);

    @Mapping(target = "bookId", ignore = true)
    void updateEntityFromDto(BookRequestDto requestDto, @MappingTarget Book book);
}
