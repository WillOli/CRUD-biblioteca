package com.bibliotecaDev.CRUD_library.service;

import com.bibliotecaDev.CRUD_library.exception.RunTimeFoundException;
import com.bibliotecaDev.CRUD_library.model.Category;
import com.bibliotecaDev.CRUD_library.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RunTimeFoundException("Category not found for this id :: " + id));

        category.setName(categoryDetails.getName());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RunTimeFoundException("Category not found for this id :: " + id));
        categoryRepository.delete(category);
    }

}
