package com.infogalaxy.librarymanagementsystemproject.repo;

import com.infogalaxy.librarymanagementsystemproject.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/***
 * IAuthorRepo Interface is Responsible to Execute the all SQL Query with the help of JpaRepository Method
 */

@Repository
public interface IAuthorRepo extends JpaRepository<AuthorEntity, Integer> {

}
