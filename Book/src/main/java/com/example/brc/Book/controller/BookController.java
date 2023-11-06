package com.example.brc.Book.controller;

import com.example.brc.Book.dto.BookDTO;
import com.example.brc.Book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private ResponseEntity<List<BookDTO>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }
}
