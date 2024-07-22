package com.bibliotecaDev.CRUD_library.repository;

import com.bibliotecaDev.CRUD_library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
