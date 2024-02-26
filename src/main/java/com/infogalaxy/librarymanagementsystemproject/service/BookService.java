package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.BookEntity;
import com.infogalaxy.librarymanagementsystemproject.repo.IBookRepo;
import org.springframework.beans.BeanUtils;
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

    @Override
    public BookEntity retrieveBookById(int id) {
        BookEntity bookEntity = iBookRepo.findById(id).get();
        return bookEntity;
    }

    @Override
    public BookEntity updateBookById(int id, BookEntity bookEntity) {
        BookEntity bookEntityNew = iBookRepo.findById(id).get();
        BeanUtils.copyProperties(bookEntity,bookEntityNew);
        return iBookRepo.save(bookEntityNew);
    }

    @Override
    public String deleteBookById(int id) {
        BookEntity bookEntity = iBookRepo.findById(id).get();
        iBookRepo.deleteById(id);
        return "Book Deleted Successfully...";
    }
}
