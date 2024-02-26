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

    @GetMapping("/retrieveallbook")
    public ResponseEntity<?> retrieveAllBook() {
        return new ResponseEntity<>(new GlobalResponses("All Book Data Found Successfully", HttpStatus.FOUND, iBookService.retrieveAllBook()), HttpStatus.FOUND);
    }

    @GetMapping("/retrievebookbyid/{id}")
    public ResponseEntity<?> retrieveBookById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new GlobalResponses("Book Data Found By Id", HttpStatus.FOUND, iBookService.retrieveBookById(id)), HttpStatus.FOUND);
    }

    @PutMapping("/updatebookbyid/{id}")
    public ResponseEntity<?> updateBookById(@PathVariable ("id") int id, @RequestBody BookEntity bookEntity) {
        return new ResponseEntity<>(new GlobalResponses("Book Data Updated Successfully", HttpStatus.ACCEPTED, iBookService.updateBookById(id, bookEntity)), HttpStatus.ACCEPTED);
    }
}
