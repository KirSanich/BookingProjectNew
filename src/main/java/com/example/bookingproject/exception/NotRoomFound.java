package com.example.bookingproject.exception;

public class NotRoomFound extends RuntimeException{
    public NotRoomFound() {
        super();
    }

    public NotRoomFound(String message) {
        super(message);
    }

    public NotRoomFound(String message, Throwable cause) {
        super(message, cause);
    }

    public NotRoomFound(Throwable cause) {
        super(cause);
    }
}
