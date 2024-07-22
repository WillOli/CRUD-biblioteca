package com.bibliotecaDev.CRUD_library.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tb_author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Lob
    private String bio;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public Author(Long id, String name, String bio) {
        this.id = id;
        this.name = name;
        this.bio = bio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
