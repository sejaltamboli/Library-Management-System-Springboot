package com.infogalaxy.librarymanagementsystemproject.service;



import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;
import com.infogalaxy.librarymanagementsystemproject.exceptions.MemberNotFoundException;
import com.infogalaxy.librarymanagementsystemproject.repo.IMemberRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public List<LibraryMemberEntity> retrieveAllMembers() {
        return iMemberRepo.findAll();
    }

    @Override
    public Optional<LibraryMemberEntity> retrieveMemberById(int id) {
        Optional<LibraryMemberEntity> libraryMemberEntity = iMemberRepo.findById(id);
        if (libraryMemberEntity.isPresent()){
            return libraryMemberEntity;
        } else {
            throw new MemberNotFoundException("Member with Given Id is not Found in Database");
        }

    }

    @Override
    public LibraryMemberEntity updateMemberById(int id, LibraryMemberEntity libraryMemberEntity) {
        Optional<LibraryMemberEntity> libraryMemberEntityNew = iMemberRepo.findById(id);
        if (libraryMemberEntityNew.isPresent()){
            BeanUtils.copyProperties(libraryMemberEntity, libraryMemberEntityNew);
            return iMemberRepo.save(libraryMemberEntity);
        } else {
            throw new MemberNotFoundException("Member with Given ID is not Found in database");
        }

    }

    @Override
    public String deleteMemberById(int id) {
        Optional<LibraryMemberEntity> libraryMemberEntity = iMemberRepo.findById(id);
        if (libraryMemberEntity.isPresent()){
            iMemberRepo.deleteById(id);
            return "Item Deleted Successfully";
        } else {
            throw new MemberNotFoundException("Member with Given ID is not Found in Database");
        }

    }


}
