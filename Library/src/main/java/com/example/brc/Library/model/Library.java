package com.example.brc.Library.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "library")
public class Library implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "UserBook")
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
