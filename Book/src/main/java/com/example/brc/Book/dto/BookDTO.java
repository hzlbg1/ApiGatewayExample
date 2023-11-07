package com.example.brc.Book.dto;

import com.example.brc.Book.model.Book;

import java.io.Serializable;

public class BookDTO implements Serializable {
    private BookIdDTO id;
    private String title;
    private String bookYear;
    private String author;
    private String pressName;

    public BookDTO(BookIdDTO id, String title, String bookYear, String author, String pressName) {
        this.id = id;
        this.title = title;
        this.bookYear = bookYear;
        this.author = author;
        this.pressName = pressName;
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

    public static BookDTO convertBookToBookDTO(Book book) {
        return new BookDTO(BookIdDTO.convert(book.getId(), book.getIsbn()), book.getTitle(), book.getBookYear(), book.getAuthor(), book.getPressName());
    }
}
