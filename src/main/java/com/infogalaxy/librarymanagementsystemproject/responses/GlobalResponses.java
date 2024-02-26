package com.infogalaxy.librarymanagementsystemproject.responses;

import lombok.Data;
import org.springframework.http.HttpStatus;

/***
 * GlobalResponses Class is Responsible to Custom Response object with response data
 */

@Data
public class GlobalResponses {

    private String message;

    private HttpStatus code;

    private Object object;

    public GlobalResponses(String message){
        this.message = message;
    }

    public GlobalResponses(String message, HttpStatus code){
        this.message = message;
        this.code = code;
    }

    public GlobalResponses(String message, HttpStatus code, Object object){
        this.message = message;
        this.code = code;
        this.object = object;

    }
}
