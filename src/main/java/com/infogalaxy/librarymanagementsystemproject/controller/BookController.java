package com.infogalaxy.librarymanagementsystemproject.controller;


import com.infogalaxy.librarymanagementsystemproject.entity.BookEntity;
import com.infogalaxy.librarymanagementsystemproject.repo.IBookRepo;
import com.infogalaxy.librarymanagementsystemproject.responses.GlobalResponses;
import com.infogalaxy.librarymanagementsystemproject.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @Autowired
    IBookService iBookService;

    @GetMapping("/home")
    public String book(){
        return "Welcome to Book API";
    }

    @PostMapping("/createbook")
    public ResponseEntity<?> createBook(@RequestBody BookEntity bookEntity) {
        return new ResponseEntity<>(new GlobalResponses("New Book Created Successfully", HttpStatus.CREATED, iBookService.createBook(bookEntity)), HttpStatus.CREATED);
    }
    
}
