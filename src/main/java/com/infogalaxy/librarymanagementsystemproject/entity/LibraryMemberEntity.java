package com.infogalaxy.librarymanagementsystemproject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/***
 * Interacting Library Member Entity Class to the Database with librarymemberentity Table
 */

@Data
@Entity
@Table(name = "librarymemberentity")
public class LibraryMemberEntity {

    @Id
    private int memberid;
    @NotBlank(message = "Please Enter the Member Name... ")
    private String membername;

    private int membermbno;
    @Email(message = "Please Enter the Member Email...")
    private String memberemail;
    @NotBlank(message = "Please Enter the Member City...")
    private String membercity;
}
