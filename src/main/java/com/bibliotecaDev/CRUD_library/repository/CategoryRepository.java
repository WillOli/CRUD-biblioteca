package com.bibliotecaDev.CRUD_library.repository;

import com.bibliotecaDev.CRUD_library.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
