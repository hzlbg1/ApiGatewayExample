package com.example.brc.Library.controller;

import com.example.brc.Library.dto.AddBookRequest;
import com.example.brc.Library.dto.LibraryDTO;
import com.example.brc.Library.model.Library;
import com.example.brc.Library.service.LibraryService;
import org.springframework.core.env.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RefreshScope
@RequestMapping("/api/v1/library")
public class LibraryController {
    Logger logger = LoggerFactory.getLogger(LibraryController.class);
    private final LibraryService libraryService;
    private final Environment environment;

//    @Value("${library-service.book.count}")
//    private String count;

    public LibraryController(LibraryService libraryService, Environment environment) {
        this.libraryService = libraryService;
        this.environment = environment;
    }

    @GetMapping
    public ResponseEntity<List<LibraryDTO>> getAllLibraries() {
        return ResponseEntity.ok(libraryService.getAllLibraries());
    }
    @GetMapping("{id}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable String id) {
        return ResponseEntity.ok(libraryService.getLibraryById(id));
    }

    @GetMapping("books/{id}")
    public ResponseEntity<LibraryDTO> getAllBooksInLibraryById(@PathVariable String id) {
        return ResponseEntity.ok(libraryService.getAllBooksInLibraryById(id));
    }

    @PostMapping
    public ResponseEntity<LibraryDTO> createLibrary() {
        logger.info("Library created on port number " + environment.getProperty("local.server.port"));
        return ResponseEntity.ok(libraryService.createLibrary());
    }

    @PutMapping
    public ResponseEntity<Void> addBookToLibrary(@RequestBody AddBookRequest request) {
        libraryService.addBookToLibrary(request);
        return ResponseEntity.ok().build();
    }

//    @GetMapping("/count")
//    public ResponseEntity<String> getCount() {
//        return ResponseEntity.ok("Library count is" + count);
//    }
}
