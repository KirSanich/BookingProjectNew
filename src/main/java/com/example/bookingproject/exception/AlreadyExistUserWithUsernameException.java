package com.example.bookingproject.exception;

public class AlreadyExistUserWithUsernameException extends RuntimeException{
    public AlreadyExistUserWithUsernameException() {
        super();
    }

    public AlreadyExistUserWithUsernameException(String message) {
        super(message);
    }

    public AlreadyExistUserWithUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistUserWithUsernameException(Throwable cause) {
        super(cause);
    }
}
