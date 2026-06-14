package com.bidirectional.config;

import com.bidirectional.dto.BookRequestDto;
import com.bidirectional.dto.BookResponseDto;
import com.bidirectional.entity.Book;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper {
    private final ModelMapper modelMapper;

    public Book toEntity(BookRequestDto bookRequestDto){
        return modelMapper.map(bookRequestDto, Book.class);
    }

    public BookResponseDto toDto(Book book){
        return modelMapper.map(book, BookResponseDto.class);
    }
}
