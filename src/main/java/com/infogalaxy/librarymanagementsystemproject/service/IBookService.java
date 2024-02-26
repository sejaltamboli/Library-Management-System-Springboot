package com.infogalaxy.librarymanagementsystemproject.service;

import com.infogalaxy.librarymanagementsystemproject.entity.BookEntity;

import java.util.List;

public interface IBookService {

    public BookEntity createBook(BookEntity bookEntity);

    public List<BookEntity> retrieveAllBook();

    public BookEntity retrieveBookById(int id);

    public BookEntity updateBookById(int id, BookEntity bookEntity);

    public String deleteBookById(int id);
}
