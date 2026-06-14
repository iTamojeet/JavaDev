package com.bidirectional.dto;

import com.bidirectional.entity.Author;

import java.util.List;

public class BookResponseDto {
    private Long bookId;
    private String title;
    private Double price;
    private String category;
    private List<Author> authors;
}
