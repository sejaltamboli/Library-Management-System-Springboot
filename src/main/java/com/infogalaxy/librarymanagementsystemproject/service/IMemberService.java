package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;

public interface IMemberService {

    public LibraryMemberEntity createMember(LibraryMemberEntity libraryMemberEntity);

    public LibraryMemberEntity retrieveMemberById(int id);

    public LibraryMemberEntity updateMemberById(int id, LibraryMemberEntity libraryMemberEntity);

    public String deleteMemberById(int id);
}
