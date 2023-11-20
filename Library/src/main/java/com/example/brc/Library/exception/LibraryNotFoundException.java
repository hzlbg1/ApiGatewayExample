package com.example.brc.Library.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class LibraryNotFoundException extends RuntimeException {
    public LibraryNotFoundException(String message) {
        super(message);
    }
}

