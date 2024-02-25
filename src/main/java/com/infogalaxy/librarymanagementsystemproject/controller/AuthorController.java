package com.infogalaxy.librarymanagementsystemproject.controller;


import com.infogalaxy.librarymanagementsystemproject.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystemproject.responses.GlobalResponses;
import com.infogalaxy.librarymanagementsystemproject.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author/api")
public class AuthorController {

    @Autowired
    IAuthorService iAuthorService;

    @GetMapping("/home")
    public String author(){
        return "Welcome to Author API";
    }

    @PostMapping("/createauthor")
    public ResponseEntity<?> createAuthor(@RequestBody AuthorEntity authorEntity){
        return new ResponseEntity<>(new GlobalResponses("New Author Created Successfully...", HttpStatus.CREATED,iAuthorService.createAuthor(authorEntity)), HttpStatus.CREATED);
    }

    @GetMapping("/retrieveallauthor")
    public ResponseEntity<?> retrieveAllAuthor(){
        return new ResponseEntity<>(new GlobalResponses("All Author Data Found Successfully..", HttpStatus.FOUND, iAuthorService.retrieveAllAuthor()), HttpStatus.FOUND);
    }
}
