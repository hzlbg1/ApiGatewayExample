package com.example.brc.Library.dto;

import java.io.Serializable;

public class BookDTO implements Serializable {
    private BookIdDTO id;
    private String title;
    private String bookYear;
    private String author;
    private String pressName;

    public BookDTO(BookIdDTO id) {
        this.id = id;
    }

    public BookIdDTO getId() {
        return id;
    }

    public void setId(BookIdDTO id) {
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
}
