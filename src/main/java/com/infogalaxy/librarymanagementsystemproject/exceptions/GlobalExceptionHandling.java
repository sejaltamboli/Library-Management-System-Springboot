package com.infogalaxy.librarymanagementsystemproject.exceptions;

import com.infogalaxy.librarymanagementsystemproject.responses.GlobalResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MemberNotFoundException.class)
    public ResponseEntity<?> membernotfoundbyid(MemberNotFoundException ex){
        return new ResponseEntity<>(new GlobalResponses("Member with Given ID Not Found in Database...", HttpStatus.NOT_FOUND), HttpStatus.NOT_FOUND);

    }



}
