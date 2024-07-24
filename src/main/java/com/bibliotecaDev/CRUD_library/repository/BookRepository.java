package com.bibliotecaDev.CRUD_library.repository;

import com.bibliotecaDev.CRUD_library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByAuthorId(Long authorId);
    List<Book> findByCategoryId(Long categoryId);
}
