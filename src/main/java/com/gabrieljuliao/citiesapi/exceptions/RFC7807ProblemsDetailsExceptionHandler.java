package com.gabrieljuliao.citiesapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RFC7807ProblemsDetailsExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler() {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        return new ResponseEntity<>(
                new RFC7807ProblemsDetails("Resource Not Found", notFound.value(), "Requested Resource Does Not Exist."),
                notFound
        );
    }
}
