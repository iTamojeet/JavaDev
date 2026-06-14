package com.bidirectional.controller;

import com.bidirectional.config.BookMapper;
import com.bidirectional.dto.BookRequestDto;
import com.bidirectional.dto.BookResponseDto;
import com.bidirectional.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
@Tag(
        name = "BOOK API BY SPRING BOOT",
        description = "BOOK MANAGEMENT OPERATION"
)
public class BookController {
    private final BookService bookService;

    @Operation(summary = "SAVE BOOK")
    @ApiResponse(responseCode = "201", description = "BOOK CREATED")
    @PostMapping
    public ResponseEntity<BookResponseDto> saveTheBook(@Valid @RequestBody BookRequestDto bookRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.save(bookRequestDto));
    }

    @Operation(summary = "GET ALL BOOKS")
    @GetMapping
    public List<BookResponseDto> getAllBooks(){
        return bookService.getAllBooks();
    }


}
