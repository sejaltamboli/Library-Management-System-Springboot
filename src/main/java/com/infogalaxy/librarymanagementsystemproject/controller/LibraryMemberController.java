package com.infogalaxy.librarymanagementsystemproject.controller;


import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;
import com.infogalaxy.librarymanagementsystemproject.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public LibraryMemberEntity createMember(@RequestBody LibraryMemberEntity libraryMemberEntity){
        return iMemberService.createMember(libraryMemberEntity);
    }

    @GetMapping("/retrievememberbyid/{id}")
    public LibraryMemberEntity retrieveMemberById(@PathVariable ("id") int id) {
        return iMemberService.retrieveMemberById(id);
    }

    @PutMapping("/updatememberbyid/{id}")
    public LibraryMemberEntity updateMemberById(@PathVariable ("id") int id, @RequestBody LibraryMemberEntity libraryMemberEntity) {
        return iMemberService.updateMemberById(id, libraryMemberEntity);
    }
}
