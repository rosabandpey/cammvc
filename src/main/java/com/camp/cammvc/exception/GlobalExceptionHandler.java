
package com.camp.cammvc.exception;

import com.camp.cammvc.entity.ErrorMessage;
import com.camp.cammvc.entity.ResponseApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

/*
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException exception, WebRequest request){

        String stackTrace= ExceptionUtils.getStackTrace(exception);
        ResponseApi responseApi=new ResponseApi(false,exception.getMessage(),new Date().toString(),null);
        return  new ResponseEntity<>(responseApi,HttpStatus.NOT_FOUND);
    } */

   /*

    @ExceptionHandler(ApiException.class)
    public String apiException(ApiException exception, WebRequest request, Model model){


        ResponseApi responseApi=new ResponseApi(false,exception.getMessage(),new Date().toString(),null);
        model.addAttribute(responseApi);
        return "error-403";

    }

    */



}
