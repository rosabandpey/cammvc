package com.camp.cammvc.exception;

import com.camp.cammvc.entity.ErrorMessage;
import com.camp.cammvc.entity.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

         @ExceptionHandler(NotFoundException.class)
         public ResponseEntity<?> notFoundException(NotFoundException exception, WebRequest request){

             String stackTrace= ExceptionUtils.getStackTrace(exception);
             ErrorMessage errorMessage=new ErrorMessage(exception.getMessage(),stackTrace,request.getDescription(false),new Date().toString());
             return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

         }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> apiException(ApiException exception, WebRequest request){

        String stackTrace= ExceptionUtils.getStackTrace(exception);
        ErrorMessage errorMessage=new ErrorMessage(exception.getMessage(),stackTrace,request.getDescription(false),new Date().toString());
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

    }

}
