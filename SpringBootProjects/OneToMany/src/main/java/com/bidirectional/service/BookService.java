package com.bidirectional.service;

import com.bidirectional.dto.BookRequestDto;
import com.bidirectional.dto.BookResponseDto;

import java.util.List;

public interface BookService {
    BookResponseDto save(BookRequestDto bookRequestDto);
    List<BookResponseDto> getAllBooks();
    BookResponseDto getBookById(Long id);
    BookResponseDto updateBookById(Long id, BookRequestDto bookRequestDto);
    void deleteBookById(Long id);
}
