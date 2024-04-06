package com.guvi.userManagementApp.exception;

import lombok.*;
import org.springframework.http.HttpStatus;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserApiException extends RuntimeException {
    private HttpStatus status;
    private String message;

}