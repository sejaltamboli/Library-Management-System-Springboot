package com.infogalaxy.librarymanagementsystemproject.repo;


import com.infogalaxy.librarymanagementsystemproject.entity.LibraryMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * IMemberRepo Interface is Responsible to Execute the all SQL Query with the help of JpaRepository Method
 */

@Repository
public interface IMemberRepo extends JpaRepository<LibraryMemberEntity, Integer> {

}
