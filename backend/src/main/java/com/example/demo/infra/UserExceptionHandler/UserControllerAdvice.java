package com.example.demo.infra.UserExceptionHandler;

import com.example.demo.infra.ErrorDetails;
import com.example.demo.infra.exceptions.UserNotFound;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<?> handlerUserNotFoundException(UserNotFound ex, WebRequest request){
        ErrorDetails errorDetails = new ErrorDetails(HttpStatus.NOT_FOUND.value(), ex.getMessage(), request.getDescription(false));

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }


}
