package com.example.brc.Book.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }

}
