package com.bibliotecaDev.CRUD_library.repository;

import com.bibliotecaDev.CRUD_library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
