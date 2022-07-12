package com.aazaykov.artplancomtest.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<AppError> handlePetNotFound(PetNotFoundException e) {
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<AppError> handleLoginIsNotVacant(LoginIsNotVacantException e) {
        return new ResponseEntity<>(new AppError(HttpStatus.IM_USED.value(), e.getMessage()), HttpStatus.IM_USED);
    }


}