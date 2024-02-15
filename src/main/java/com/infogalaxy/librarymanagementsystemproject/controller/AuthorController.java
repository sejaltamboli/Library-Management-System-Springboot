package com.infogalaxy.librarymanagementsystemproject.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author/api")
public class AuthorController {

    @GetMapping("/home")
    public String author(){
        return "Welcome to Author API";
    }


}
