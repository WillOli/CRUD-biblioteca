package com.bibliotecaDev.CRUD_library.controller;
import com.bibliotecaDev.CRUD_library.model.Author;
import com.bibliotecaDev.CRUD_library.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class AuthorControllerTest {

    @Mock
    private AuthorService authorService;

    @InjectMocks
    private AuthorController authorController;

    private Author author;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        author = new Author(1L, "John Doe", "An accomplished author.");
    }

    @Test
    public void testCreateAuthor() {
        when(authorService.createAuthor(any(Author.class))).thenReturn(author);

        ResponseEntity<Author> response = authorController.createAuthor(author);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(author.getName(), response.getBody().getName());
    }

    @Test
    public void testGetAllAuthors() {
        when(authorService.getAllAuthors()).thenReturn(Collections.singletonList(author));

        ResponseEntity<List<Author>> response = authorController.getAllAuthors();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1, response.getBody().size());
        assertEquals(author.getName(), response.getBody().get(0).getName());
    }

    @Test
    public void testGetAuthorById() {
        when(authorService.getAuthorById(anyLong())).thenReturn(Optional.of(author));

        ResponseEntity<Author> response = authorController.getAuthorById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(author.getName(), response.getBody().getName());
    }

    @Test
    public void testGetAuthorById_NotFound() {
        when(authorService.getAuthorById(anyLong())).thenReturn(Optional.empty());

        ResponseEntity<Author> response = authorController.getAuthorById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testUpdateAuthor() {
        when(authorService.updateAuthor(anyLong(), any(Author.class))).thenReturn(author);

        ResponseEntity<Author> response = authorController.updateAuthor(1L, author);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(author.getName(), response.getBody().getName());
    }

    @Test
    public void testDeleteAuthor() {
        doNothing().when(authorService).deleteAuthor(anyLong());

        ResponseEntity<Void> response = authorController.deleteAuthor(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(authorService, times(1)).deleteAuthor(1L);
    }
}

