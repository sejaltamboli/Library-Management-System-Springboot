package com.infogalaxy.librarymanagementsystemproject.repo;

import com.infogalaxy.librarymanagementsystemproject.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthorRepo extends JpaRepository<AuthorEntity, Integer> {

}
