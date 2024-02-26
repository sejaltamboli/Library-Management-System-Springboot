package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystemproject.repo.IAuthorRepo;
import org.springframework.beans.BeanUtils;
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

    @Override
    public AuthorEntity retrieveAuthorById(int id) {
        AuthorEntity authorEntity = iAuthorRepo.findById(id).get() ;
        return iAuthorRepo.findById(id).get();
    }

    @Override
    public AuthorEntity updateAuthorById(int id, AuthorEntity authorEntity) {
        AuthorEntity authorEntityNew = iAuthorRepo.findById(id).get();
        BeanUtils.copyProperties(authorEntity,authorEntityNew);
        return iAuthorRepo.save(authorEntityNew);
    }

    @Override
    public String deleteAuthorById(int id) {
        AuthorEntity authorEntity = iAuthorRepo.findById(id).get();
        iAuthorRepo.deleteById(id);
        return "Author Deleted Successfully...";
    }
}
