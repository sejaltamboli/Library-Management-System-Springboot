package com.infogalaxy.librarymanagementsystemproject.service;



import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;
import com.infogalaxy.librarymanagementsystemproject.repo.IMemberRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements IMemberService{

    @Autowired
    IMemberRepo iMemberRepo;

    @Override
    public LibraryMemberEntity createMember(LibraryMemberEntity libraryMemberEntity) {
        iMemberRepo.save(libraryMemberEntity);
        return libraryMemberEntity;
    }

    @Override
    public LibraryMemberEntity retrieveMemberById(int id) {
        return iMemberRepo.findById(id).get();
    }

    @Override
    public LibraryMemberEntity updateMemberById(int id, LibraryMemberEntity libraryMemberEntity) {
        LibraryMemberEntity libraryMemberEntityNew = retrieveMemberById(id);
        BeanUtils.copyProperties(libraryMemberEntity, libraryMemberEntityNew);
        return iMemberRepo.save(libraryMemberEntityNew);
    }
}
