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

    /***
     * To Create Object of Author Repo Interface
     */
    @Autowired
    IAuthorRepo iAuthorRepo;

    /***
     * Method to Add New Author Data in Database
     * @param authorEntity - Object of AuthorEntity
     * @return authorEntity - Object of AuthorEntity(Author)
     */
    @Override
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
        iAuthorRepo.save(authorEntity);
        return authorEntity;
    }

    /***
     * Method to Retrieve All Authors Data From Database
     * @return List - List of AuthorEntity Objects
     */
    @Override
    public List<AuthorEntity> retrieveAllAuthor() {
        return iAuthorRepo.findAll();
    }

    /***
     * Method to Retrieve Author Data From Database with the help of Author ID
     * @param id - Find the Author Data By the given ID
     * @return authorEntity - AuthorEntity Object with the help of Author ID
     */
    @Override
    public Optional<AuthorEntity> retrieveAuthorById(int id) {
        Optional<AuthorEntity> authorEntity = iAuthorRepo.findById(id);
        if (authorEntity.isPresent()) {
            return authorEntity;
        } else {
            throw new MemberNotFoundException("Author with Given Id is not Found I Database");
        }
    }

    /***
     * Method to Update existing Author data with the help of Author ID
     * @param id - Access the Author Data from given Database
     * @param authorEntity - Object of AuthorEntity
     * @return AuthorEntityNew - Object of New Updated Data
     */
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

    /***
     * Method to Delete existing Author Data with the help of Author ID
     * @param id - Access the Author Data from Database
     * @return String - Display the Delete Successfully message
     */
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
