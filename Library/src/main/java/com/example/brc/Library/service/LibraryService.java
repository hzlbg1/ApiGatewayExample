package com.example.brc.Library.service;

import com.example.brc.Library.dto.AddBookRequest;
import com.example.brc.Library.dto.BookIdDTO;
import com.example.brc.Library.dto.LibraryDTO;
import com.example.brc.Library.exception.LibraryNotFoundException;
import com.example.brc.Library.model.Library;
import com.example.brc.Library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    private List<LibraryDTO> findAllLibraries() {
        return libraryRepository.findAll().stream().map(LibraryDTO::convert).collect(Collectors.toList());
    }

//    public LibraryDTO getAllBooksInLibraryById(String id) {
//        Library library = libraryRepository.findById(id)
//                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));
//
//        LibraryDTO libraryDto = new LibraryDTO(library.getId(),
//                library.getUserBook()
//                        .stream()
//                        .map(book -> bookServiceClient.getBookById(book).getBody())
//                        .collect(Collectors.toList()));
//        return libraryDto;
//    }

    public LibraryDTO createLibrary() {
        Library newLibrary = libraryRepository.save(new Library());
        return new LibraryDTO(newLibrary.getId());
    }

//    public void addBookToLibrary(AddBookRequest request) {
//        BookIdDTO bookIdByIsbn = bookServiceBlockingStub.getBookIdByIsbn(Isbn.newBuilder().setIsbn(request.getIsbn()).build());
//        String bookId = bookIdByIsbn.getBookId();
//
//        Library library = libraryRepository.findById(request.getId())
//                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + request.getId()));
//
//        library.getUserBook()
//                .add(bookId);
//
//        libraryRepository.save(library);
//    }


    public List<String> getAllLibraries() {

        return libraryRepository.findAll()
                .stream()
                .map(l -> l.getId())
                .collect(Collectors.toList());
    }
}
