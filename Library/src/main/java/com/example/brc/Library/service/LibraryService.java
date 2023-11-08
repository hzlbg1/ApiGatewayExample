package com.example.brc.Library.service;

import com.example.brc.Library.client.BookServiceClient;
import com.example.brc.Library.dto.AddBookRequest;
import com.example.brc.Library.dto.BookIdDTO;
import com.example.brc.Library.dto.LibraryDTO;
import com.example.brc.Library.exception.LibraryNotFoundException;
import com.example.brc.Library.model.Library;
import com.example.brc.Library.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {
    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    private List<LibraryDTO> findAllLibraries() {
        return libraryRepository
                .findAll()
                .stream()
                .map(LibraryDTO::convert).
                collect(Collectors.toList());
    }

    public LibraryDTO getAllBooksInLibraryById(String id) {
            return libraryRepository
                .findById(id)
                .map(LibraryDTO::convert)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));

//        LibraryDTO libraryDTO = new LibraryDTO(library.getId(), library.getUserBook()
//                .stream()
//                .map(book -> bookServiceClient.getBookById(book).getBody().getId()) // feignclient
//                .collect(Collectors.toList()));
//        return libraryDto;
    }

    public LibraryDTO createLibrary(Library library) {
        Library newLibrary = libraryRepository.save(library);
        return LibraryDTO.convert(newLibrary);
    }

//    public void addBookToLibrary(AddBookRequest request) {
//        BookId bookIdByIsbn = bookServiceBlockingStub.getBookIdByIsbn(Isbn.newBuilder().setIsbn(request.getIsbn()).build());
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


    public List<LibraryDTO> getAllLibraries() {

        return libraryRepository.findAll()
                .stream()
                .map(LibraryDTO::convert)
                .collect(Collectors.toList());
    }
}
