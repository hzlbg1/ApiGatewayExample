package com.example.brc.Library.dto;

import com.example.brc.Library.model.Library;

import java.io.Serializable;
import java.util.List;

public class LibraryDTO implements Serializable {
    private String id;
    private List<String> userBookMap;

    public LibraryDTO(String id, List<String> userBookMap) {
        this.id = id;
        this.userBookMap = userBookMap;
    }

    public LibraryDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getUserBookMap() {
        return userBookMap;
    }

    public void setUserBookMap(List<String> userBookMap) {
        this.userBookMap = userBookMap;
    }

    public static LibraryDTO convert(Library library) {
        return new LibraryDTO(library.getId(), library.getUserBook());
    }
}
