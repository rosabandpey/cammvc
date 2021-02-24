package com.camp.cammvc.exception;

public class ApiException extends RuntimeException {


    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiException(String message) {
        super(message);

    }
}
