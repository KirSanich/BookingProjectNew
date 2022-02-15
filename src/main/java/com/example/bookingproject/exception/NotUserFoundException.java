package com.example.bookingproject.exception;


public class NotUserFoundException extends RuntimeException {
    public NotUserFoundException() {
        super();
    }

    public NotUserFoundException(String message) {
        super(message);
    }

    public NotUserFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUserFoundException(Throwable cause) {
        super(cause);
    }
}
