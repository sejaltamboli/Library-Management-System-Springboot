package com.infogalaxy.librarymanagementsystemproject.controller;


import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;
import com.infogalaxy.librarymanagementsystemproject.responses.MemberResponses;
import com.infogalaxy.librarymanagementsystemproject.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member/api")
public class LibraryMemberController {

    @Autowired
    IMemberService iMemberService;

    @GetMapping("/home")
    public String libraryMember(){
        return "Welcome To Library Member API";
    }

    @PostMapping("/createmember")
    public ResponseEntity<?> createMember(@RequestBody LibraryMemberEntity libraryMemberEntity){
        return new ResponseEntity<>(new MemberResponses("New Member Created Successfully...", HttpStatus.CREATED,iMemberService.createMember(libraryMemberEntity)), HttpStatus.CREATED);
    }

    @GetMapping("/retrieveallmembers")
    public ResponseEntity<?> retrieveAllMembers(){
        return new ResponseEntity<>(new MemberResponses("All Member Data Found Successfully..",HttpStatus.FOUND,iMemberService.retrieveAllMembers()), HttpStatus.FOUND);
    }

    @GetMapping("/retrievememberbyid/{id}")
    public ResponseEntity<?> retrieveMemberById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new MemberResponses("Member Data Found By ID",HttpStatus.FOUND,iMemberService.retrieveMemberById(id)),HttpStatus.FOUND);
    }

    @PutMapping("/updatememberbyid/{id}")
    public LibraryMemberEntity updateMemberById(@PathVariable ("id") int id, @RequestBody LibraryMemberEntity libraryMemberEntity) {
        return iMemberService.updateMemberById(id, libraryMemberEntity);
    }

    @DeleteMapping ("/deletememberbyid/{id}")
    public String deleteMemberById(@PathVariable ("id") int id) {
        return iMemberService.deleteMemberById(id);

    }
}
