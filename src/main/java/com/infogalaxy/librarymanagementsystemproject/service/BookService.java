package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.BookEntity;
import com.infogalaxy.librarymanagementsystemproject.exceptions.MemberNotFoundException;
import com.infogalaxy.librarymanagementsystemproject.repo.IBookRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<BookEntity> retrieveBookById(int id) {
        Optional<BookEntity> bookEntity = iBookRepo.findById(id);
        if (bookEntity.isPresent()){
            return bookEntity;
        } else  {
            throw new MemberNotFoundException("Book with Given Id is not Found in Database");
        }

    }

    @Override
    public BookEntity updateBookById(int id, BookEntity bookEntity) {
        Optional<BookEntity> bookEntityNew = iBookRepo.findById(id);
        if (bookEntityNew.isPresent()) {
            BeanUtils.copyProperties(bookEntity, bookEntityNew);
            return iBookRepo.save(bookEntity);
        } else {
            throw new MemberNotFoundException("Book with Given Id is not Found in Database");
        }
    }

    @Override
    public String deleteBookById(int id) {
        Optional<BookEntity> bookEntity = iBookRepo.findById(id);
        if (bookEntity.isPresent()) {
            iBookRepo.deleteById(id);
            return "Book Deleted Successfully...";
        } else  {
            throw new MemberNotFoundException("Book with Given Id is not Found in Database");
        }
    }
}
