package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.AuthorEntity;

import java.util.List;

public interface IAuthorService {

    public AuthorEntity createAuthor(AuthorEntity authorEntity);

    public List<AuthorEntity> retrieveAllAuthor();
}
