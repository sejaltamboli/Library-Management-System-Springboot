package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.AuthorEntity;
import com.infogalaxy.librarymanagementsystemproject.exceptions.MemberNotFoundException;
import com.infogalaxy.librarymanagementsystemproject.repo.IAuthorRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<AuthorEntity> retrieveAuthorById(int id) {
        Optional<AuthorEntity> authorEntity = iAuthorRepo.findById(id);
        if (authorEntity.isPresent()) {
            return authorEntity;
        } else {
            throw new MemberNotFoundException("Author with Given Id is not Found I Database");
        }
    }

    @Override
    public AuthorEntity updateAuthorById(int id, AuthorEntity authorEntity) {
        Optional<AuthorEntity> authorEntityNew = iAuthorRepo.findById(id);
        if (authorEntityNew.isPresent()) {
            BeanUtils.copyProperties(authorEntity, authorEntityNew);
            return iAuthorRepo.save(authorEntity);
        } else {
            throw new MemberNotFoundException("Author with Given Id is not Found I Database");
        }
    }

    @Override
    public String deleteAuthorById(int id) {
        Optional<AuthorEntity> authorEntity = iAuthorRepo.findById(id);
        if (authorEntity.isPresent()) {
            iAuthorRepo.deleteById(id);
            return "Author Deleted Successfully...";
        } else {
            throw new MemberNotFoundException("Author with Given Id is not Found I Database");
        }
    }
}
