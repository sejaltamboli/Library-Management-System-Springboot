package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;

import java.util.List;
import java.util.Optional;

public interface IMemberService {

    public LibraryMemberEntity createMember(LibraryMemberEntity libraryMemberEntity);

    public List<LibraryMemberEntity> retrieveAllMembers();

    public Optional<LibraryMemberEntity> retrieveMemberById(int id);

    public LibraryMemberEntity updateMemberById(int id, LibraryMemberEntity libraryMemberEntity);

    public String deleteMemberById(int id);
}
