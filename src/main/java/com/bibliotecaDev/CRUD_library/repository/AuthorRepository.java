package com.bibliotecaDev.CRUD_library.repository;

import com.bibliotecaDev.CRUD_library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
