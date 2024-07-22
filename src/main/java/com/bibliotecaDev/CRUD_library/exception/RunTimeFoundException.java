package com.bibliotecaDev.CRUD_library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunTimeFoundException  extends RuntimeException{
    public RunTimeFoundException(String message) {
        super(message);
    }
}
