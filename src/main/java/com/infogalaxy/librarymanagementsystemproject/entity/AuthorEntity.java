package com.infogalaxy.librarymanagementsystemproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class AuthorEntity {

    @Id
    private int authorid;

    private String authorname;

    private String authorcountry;
}
