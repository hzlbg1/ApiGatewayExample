package com.example.brc.Library.repository;

import com.example.brc.Library.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface LibraryRepository extends JpaRepository<Library, String> {
}
