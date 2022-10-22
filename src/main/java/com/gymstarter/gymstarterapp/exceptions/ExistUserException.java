package com.gymstarter.gymstarterapp.exceptions;

public class ExistUserException extends RuntimeException{

    public ExistUserException(String msg) {
        super(msg);
    }
}
