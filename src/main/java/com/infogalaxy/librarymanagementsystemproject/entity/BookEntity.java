package com.infogalaxy.librarymanagementsystemproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/***
 * Interacting Book Entity Class to the Database with bookentity Table
 */

@Entity
@Data
@Table(name = "bookentity")
public class BookEntity {

    @Id
    private int bookid;
    @NotBlank(message = "Please Enter the Book Title...")
    private String booktitle;
    @NotBlank(message = "Please Enter the Book Author Name...")
    private String bookauthorname;
    //@NotNull(message = "Please Enter the Book Price...")
    private int bookprice;
    @NotBlank(message = "Please Enter the Book ISBN Number...")
    private String bookisbnno;
    //@NotNull(message = "Please Enter the Book Publish Year...")
    private int bookpublishyear;
    
}
