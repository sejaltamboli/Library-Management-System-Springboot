package com.infogalaxy.librarymanagementsystemproject.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class MemberResponses {

    private String message;

    private HttpStatus code;

    private Object object;

    public MemberResponses(){

    }

    public MemberResponses(String message){
        this.message = message;
    }

    public MemberResponses(String message, HttpStatus code){
        this.message = message;
        this.code = code;
    }

    public MemberResponses(String message, HttpStatus code, Object object){
        this.message = message;
        this.code = code;
        this.object = object;

    }
}
