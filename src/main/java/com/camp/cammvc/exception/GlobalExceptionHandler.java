
package com.camp.cammvc.exception;

import com.camp.cammvc.entity.ErrorMessage;
import com.camp.cammvc.entity.ResponseApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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


    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String notFoundException(NotFoundException exception, WebRequest request, Model model){

        ResponseApi responseApi=new ResponseApi(false,exception.getMessage(),new Date().toString(),null);
        model.addAttribute(responseApi);
        return  "error/error-404";
    }



    @ExceptionHandler(ApiException.class)
    public String apiException(ApiException exception, WebRequest request, Model model) throws JsonProcessingException {

        ResponseApi responseApi=new ResponseApi(false,exception.getMessage(),new Date().toString(),null);
        model.addAttribute(responseApi);
        return "error/error-403";

    }

    @ExceptionHandler(Exception.class)
    public String globalException(Exception exception, WebRequest request, Model model) throws JsonProcessingException {

        ResponseApi responseApi=new ResponseApi(false,exception.getCause().getMessage(),new Date().toString(),null);

        model.addAttribute(responseApi);
        return "error/error-500";

    }



}
