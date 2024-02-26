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

    /***
     * To Create Object of Member Repo Interface
     */
    @Autowired
    IMemberRepo iMemberRepo;

    /***
     * Method to Add New Member Data in Database
     * @param libraryMemberEntity - Object of LibraryMemberEntity
     * @return libraryMemberEntity - Object of LibraryMemberEntity(Member)
     */
    @Override
    public LibraryMemberEntity createMember(LibraryMemberEntity libraryMemberEntity) {
        iMemberRepo.save(libraryMemberEntity);
        return libraryMemberEntity;
    }

    /***
     * Method to Retrieve All Members Data From Database
     * @return List - List of LibraryMemberEntity Objects
     */
    @Override
    public List<LibraryMemberEntity> retrieveAllMembers() {
        return iMemberRepo.findAll();
    }

    /***
     * Method to Retrieve Member Data From Database with the help of Member ID
     * @param id - Find the Member Data By the given ID
     * @return libraryMemberEntity - LibraryMemberEntity Object with the help of Member ID
     */
    @Override
    public Optional<LibraryMemberEntity> retrieveMemberById(int id) {
        Optional<LibraryMemberEntity> libraryMemberEntity = iMemberRepo.findById(id);
        if (libraryMemberEntity.isPresent()) {
            return libraryMemberEntity;
        } else  {
            throw new MemberNotFoundException("Member with Given Id is not Found in Database");
        }
    }

    /***
     * Method to Update existing Member data with the help of Member ID
     * @param id - Access the Member Data from given Database
     * @param libraryMemberEntity - Object of LibraryMemberEntity
     * @return libraryMemberEntityNew - Object of New Updated Data
     */
    @Override
    public LibraryMemberEntity updateMemberById(int id, LibraryMemberEntity libraryMemberEntity) {
       Optional<LibraryMemberEntity> libraryMemberEntityNew = iMemberRepo.findById(id);
       if (libraryMemberEntityNew.isPresent()) {
           BeanUtils.copyProperties(libraryMemberEntity,libraryMemberEntityNew);
           return iMemberRepo.save(libraryMemberEntity);
       } else {
           throw new MemberNotFoundException("Member with Given Id is not Found in Database");
       }
    }

    /***
     * Method to Delete existing Member Data with the help of Member ID
     * @param id - Access the Member Data from Database
     * @return String - Display the Delete Successfully message
     */
    @Override
    public String deleteMemberById(int id) {
        Optional<LibraryMemberEntity> libraryMemberEntity = iMemberRepo.findById(id);
        if (libraryMemberEntity.isPresent()) {
            iMemberRepo.deleteById(id);
            return "Item Deleted Successfully";
        } else  {
            throw new MemberNotFoundException("Member with Given Id is not Found in Database");
        }
    }
}
