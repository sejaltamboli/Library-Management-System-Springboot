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

    /***
     * To Create Object of Member Service Interface
     */
    @Autowired
    IMemberService iMemberService;

    /***
     *
     * @return String - Welcome to library Member API
     */
    @GetMapping("/home")
    public String libraryMember(){
        return "Welcome To Library Member API";
    }

    /***
     * API to create Member Data in Database
     * @param libraryMemberEntity - Object of LibraryMemberEntity
     * @return GlobalResponse - Custom Response object with response data
     */
    @PostMapping("/createmember")
    public ResponseEntity<?> createMember(@RequestBody @Valid LibraryMemberEntity libraryMemberEntity){
        return new ResponseEntity<>(new GlobalResponses("New Member Created Successfully...", HttpStatus.CREATED,iMemberService.createMember(libraryMemberEntity)), HttpStatus.CREATED);
    }

    /***
     * API to retrieve all member data in Database
     * @return GlobalResponse - Custom Response object with response data
     */
    @GetMapping("/retrieveallmembers")
    public ResponseEntity<?> retrieveAllMembers(){
        return new ResponseEntity<>(new GlobalResponses("All Member Data Found Successfully..",HttpStatus.FOUND,iMemberService.retrieveAllMembers()), HttpStatus.FOUND);
    }

    /***
     * API to Retrieve the existing Member Data from Database with the help of Member ID
     * @param id - Find the Member Data By the given ID
     * @return GlobalResponse - Custom Response object with response data
     */
    @GetMapping("/retrievememberbyid/{id}")
    public ResponseEntity<?> retrieveMemberById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new GlobalResponses("Member Data Found By ID",HttpStatus.FOUND,iMemberService.retrieveMemberById(id)),HttpStatus.FOUND);
    }

    /***
     * API to Update existing member data in database with the help of member ID
     * @param id - Find the Member Data By the given ID
     * @param libraryMemberEntity - Object of LibraryMemberEntity
     * @return GlobalResponse - Custom Response object with response data
     */
    @PutMapping("/updatememberbyid/{id}")
    public ResponseEntity<?> updateMemberById(@PathVariable ("id") int id, @RequestBody LibraryMemberEntity libraryMemberEntity) {
        return new ResponseEntity<>(new GlobalResponses("Member Data Updated Successfully",HttpStatus.PROCESSING,iMemberService.updateMemberById(id,libraryMemberEntity)), HttpStatus.PROCESSING);
    }

    /***
     * API to Delete existing Member Data from Database with the help of Member ID
     * @param id - Find the Member Data By the given ID
     * @return GlobalResponse - Custom Response object with response data
     */

    @DeleteMapping ("/deletememberbyid/{id}")
    public ResponseEntity<?> deleteMemberById(@PathVariable ("id") int id) {
        return new ResponseEntity<>(new GlobalResponses("Member Data Deleted Successfully..",HttpStatus.ACCEPTED,iMemberService.deleteMemberById(id)), HttpStatus.ACCEPTED);

    }
}
