package com.infogalaxy.librarymanagementsystemproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "authorentity")
public class AuthorEntity {

    @Id
    private int authorid;

    private String authorname;

    private String authorcountry;
}
