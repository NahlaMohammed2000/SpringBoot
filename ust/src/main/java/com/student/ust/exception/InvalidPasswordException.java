package com.student.ust.exception;

public class InvalidPasswordException extends BusinessException {
    public  InvalidPasswordException(){
        super("invalid password format");
    }
}
