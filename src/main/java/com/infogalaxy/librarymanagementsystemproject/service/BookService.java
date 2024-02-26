package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.BookEntity;
import com.infogalaxy.librarymanagementsystemproject.repo.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    IBookRepo iBookRepo;


    @Override
    public BookEntity createBook(BookEntity bookEntity) {
        iBookRepo.save(bookEntity);
        return bookEntity;
    }

    @Override
    public List<BookEntity> retrieveAllBook() {
        return iBookRepo.findAll();
    }
}
