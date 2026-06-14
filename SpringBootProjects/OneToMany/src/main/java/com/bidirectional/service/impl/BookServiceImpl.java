package com.bidirectional.service.impl;

import com.bidirectional.config.BookMapper;
import com.bidirectional.dto.BookRequestDto;
import com.bidirectional.dto.BookResponseDto;
import com.bidirectional.entity.Book;
import com.bidirectional.exception.BookNotFoundException;
import com.bidirectional.repository.BookRepository;
import com.bidirectional.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookResponseDto save(BookRequestDto bookRequestDto) {
        Book saved = bookRepository.save(bookMapper.toEntity(bookRequestDto));
        return bookMapper.toDto(saved);
    }

    @Override
    public List<BookResponseDto> getAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }

    @Override
    public BookResponseDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException("Paini boi ta!"));
        return bookMapper.toDto(book);
    }

    @Override
    public BookResponseDto updateBookById(Long id, BookRequestDto bookRequestDto) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException("Paini boi ta!"));
        book.setTitle(bookRequestDto.getTitle());
        book.setPrice(bookRequestDto.getPrice());
        Book updated = bookRepository.save(book);
        return bookMapper.toDto(updated);
    }

    @Override
    public void deleteBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() ->
                new BookNotFoundException("Paini boi ta!"));
        bookRepository.deleteById(id);
    }
}
