package com.infogalaxy.librarymanagementsystemproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "bookentity")
public class BookEntity {

    @Id
    private int bookid;

    private String booktitle;

    private String bookauthorname;

    private int bookprice;

    private String bookisbnno;

    private int bookpublishyear;
    
}
