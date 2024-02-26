package com.infogalaxy.librarymanagementsystemproject.controller;


import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;
import com.infogalaxy.librarymanagementsystemproject.responses.GlobalResponses;
import com.infogalaxy.librarymanagementsystemproject.service.IMemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createMember(@RequestBody @Valid LibraryMemberEntity libraryMemberEntity){
        return new ResponseEntity<>(new GlobalResponses("New Member Created Successfully...", HttpStatus.CREATED,iMemberService.createMember(libraryMemberEntity)), HttpStatus.CREATED);
    }

    @GetMapping("/retrieveallmembers")
    public ResponseEntity<?> retrieveAllMembers(){
        return new ResponseEntity<>(new GlobalResponses("All Member Data Found Successfully..",HttpStatus.FOUND,iMemberService.retrieveAllMembers()), HttpStatus.FOUND);
    }

    @GetMapping("/retrievememberbyid/{id}")
    public ResponseEntity<?> retrieveMemberById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new GlobalResponses("Member Data Found By ID",HttpStatus.FOUND,iMemberService.retrieveMemberById(id)),HttpStatus.FOUND);
    }

    @PutMapping("/updatememberbyid/{id}")
    public ResponseEntity<?> updateMemberById(@PathVariable ("id") int id, @RequestBody LibraryMemberEntity libraryMemberEntity) {
        return new ResponseEntity<>(new GlobalResponses("Member Data Updated Successfully",HttpStatus.PROCESSING,iMemberService.updateMemberById(id,libraryMemberEntity)), HttpStatus.PROCESSING);
    }

    @DeleteMapping ("/deletememberbyid/{id}")
    public ResponseEntity<?> deleteMemberById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new GlobalResponses("Member Data Deleted Successfully..",HttpStatus.ACCEPTED,iMemberService.deleteMemberById(id)), HttpStatus.ACCEPTED);

    }
}
