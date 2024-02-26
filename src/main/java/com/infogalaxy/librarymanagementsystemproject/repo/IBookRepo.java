package com.infogalaxy.librarymanagementsystemproject.repo;

import com.infogalaxy.librarymanagementsystemproject.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepo extends JpaRepository<BookEntity, Integer> {
}
