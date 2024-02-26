package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.AuthorEntity;

import java.util.List;
import java.util.Optional;

/***
 * IAuthorService Interface is used to Declare the Author Functions
 */

public interface IAuthorService {

    public AuthorEntity createAuthor(AuthorEntity authorEntity);

    public List<AuthorEntity> retrieveAllAuthor();

    public Optional<AuthorEntity> retrieveAuthorById(int id);

    public AuthorEntity updateAuthorById(int id, AuthorEntity authorEntity);

    public String deleteAuthorById(int id);
}
