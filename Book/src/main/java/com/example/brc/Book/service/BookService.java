package com.example.brc.Book.service;

import com.example.brc.Book.dto.BookDTO;
import com.example.brc.Book.dto.BookIdDTO;
import com.example.brc.Book.exception.BookNotFoundException;
import com.example.brc.Book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> findAllBooks() {
        return bookRepository.findAll().stream().map(BookDTO::convertBookToBookDTO).collect(Collectors.toList());
    }

    public BookIdDTO findByIsbn(String isbn) {
        return bookRepository.getBookByIsbn(isbn)
                .map(book -> new BookIdDTO(book.getId(), book.getIsbn()))
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: " + isbn));
    }

    public BookDTO findBookDetailsById(String id) {
        return bookRepository.findById(id)
                .map(BookDTO::convertBookToBookDTO)
                .orElseThrow(() -> new BookNotFoundException("Book could not found by id:" + id));
    }
}
