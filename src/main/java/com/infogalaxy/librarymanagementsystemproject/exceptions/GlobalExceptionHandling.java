package com.infogalaxy.librarymanagementsystemproject.exceptions;

import com.infogalaxy.librarymanagementsystemproject.responses.GlobalResponses;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<?> membernotfoundbyid(MemberNotFoundException ex){
        return new ResponseEntity<>(new GlobalResponses("Member with Given ID Not Found in Database...", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);

    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> erroemap = new HashMap<>();
        for (FieldError field : ex.getFieldErrors()) {
            erroemap.put(field.getField(), field.getDefaultMessage());
        }
        return new ResponseEntity<>(new GlobalResponses("Please Check Input Data...", HttpStatus.BAD_REQUEST, erroemap), HttpStatus.BAD_REQUEST);
    }
}
