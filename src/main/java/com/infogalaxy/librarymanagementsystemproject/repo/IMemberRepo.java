package com.infogalaxy.librarymanagementsystemproject.repo;


import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMemberRepo extends JpaRepository<LibraryMemberEntity, Integer> {

}
