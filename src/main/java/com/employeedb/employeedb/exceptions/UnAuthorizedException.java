package com.employeedb.employeedb.exceptions;

public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException ( String message ) {
        super (message);
    }
}
