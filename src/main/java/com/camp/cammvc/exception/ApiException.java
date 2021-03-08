package com.camp.cammvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.FORBIDDEN)
public class ApiException extends RuntimeException {


    public ApiException(String message) {
        super(message);

    }
}
