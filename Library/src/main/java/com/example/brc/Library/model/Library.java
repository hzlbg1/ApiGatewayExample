package com.example.brc.Library.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "library")
public class Library implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

//    @ElementCollection
    @Column(name = "user_book")
    private List<String> userBook;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUserBook() {
        return userBook;
    }

    public void setUserBook(List<String> userBook) {
        this.userBook = userBook;
    }
}
