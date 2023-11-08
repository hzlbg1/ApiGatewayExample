package com.example.brc.Library.service;

import com.example.brc.Library.client.BookServiceClient;
import com.example.brc.Library.dto.AddBookRequest;
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
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }
    public List<LibraryDTO> getAllLibraries() {

        return libraryRepository.findAll()
                .stream()
                .map(LibraryDTO::convert)
                .collect(Collectors.toList());
    }
    public LibraryDTO getLibraryById(String id) {
        return libraryRepository
                .findById(id)
                .map(LibraryDTO::convert)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));
    }

    public LibraryDTO getAllBooksInLibraryById(String id) {
        Library library = libraryRepository
                .findById(id)
                .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + id));

        library.getUserBook()
                .stream()
                .map(book -> bookServiceClient.getBookById(book).getBody())
                .collect(Collectors.toList());

        return LibraryDTO.convert(library);
    }

    public LibraryDTO createLibrary() {
        Library newLibrary = libraryRepository.save(new Library());
        return LibraryDTO.convert(newLibrary);
    }

    public void addBookToLibrary(AddBookRequest request) {
       String bookId = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getId();

       Library library = libraryRepository
               .findById(request.getId())
               .orElseThrow(() -> new LibraryNotFoundException("Library could not found by id: " + request.getId()));

       library.getUserBook().add(bookId);

       libraryRepository.save(library);
    }

}
