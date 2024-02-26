package com.infogalaxy.librarymanagementsystemproject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book/api")
public class BookController {

    @GetMapping("/home")
    public String book(){
        return "Welcome to Book API";
    }
    
}
