package com.employeedb.employeedb.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException ( String message ) {
        super (message);
    }
}
