package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystemproject.repo.IAuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    IAuthorRepo iAuthorRepo;


    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        iAuthorRepo.save(authorEntity);
        return authorEntity;
    }

    @Override
    public List<AuthorEntity> retrieveAllAuthor() {
        return iAuthorRepo.findAll();
    }
}
