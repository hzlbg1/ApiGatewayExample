package com.example.brc.Library.dto;

import java.io.Serializable;

public class BookDTO implements Serializable {
    private String id;
    private String title;
    private String bookYear;
    private String author;
    private String pressName;
    private String isbn;
    private BookIdDTO bookIdDTO;

    public BookDTO(BookIdDTO bookIdDTO) {
        this.bookIdDTO = bookIdDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBookYear() {
        return bookYear;
    }

    public void setBookYear(String bookYear) {
        this.bookYear = bookYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookIdDTO getBookIdDTO() {
        return bookIdDTO;
    }

    public void setBookIdDTO(BookIdDTO bookIdDTO) {
        this.bookIdDTO = bookIdDTO;
    }
}
