package com.guvi.userManagementApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST) //400
public class EmailAlreadyExistException extends RuntimeException{
    private String message;

    public EmailAlreadyExistException(String message) {
        super(message);
    }
}