package com.infogalaxy.librarymanagementsystemproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "librarymemberentity")
public class LibraryMemberEntity {

    @Id
    private int memberid;

    private String membername;

    private int membermbno;

    private String memberemail;

    private String membercity;
}
