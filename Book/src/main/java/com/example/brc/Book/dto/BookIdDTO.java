package com.example.brc.Book.dto;

import java.io.Serializable;
public class BookIdDTO implements Serializable {
    private String id;
    private String isbn;

    public BookIdDTO(String id, String isbn) {
        this.id = id;
        this.isbn = isbn;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public static BookIdDTO convert(String id, String isbn) {
        return new BookIdDTO(id, isbn);
    }

}
