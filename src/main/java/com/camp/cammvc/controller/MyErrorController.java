package com.camp.cammvc.controller;

import com.camp.cammvc.entity.ResponseApi;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class MyErrorController implements ErrorController {

    private final ErrorAttributes errorAttributes;
    ResponseApi responseApi;
    public MyErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(Model model,  WebRequest webRequest,HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());



            if(statusCode == HttpStatus.NOT_FOUND.value()) {

                System.out.println(statusCode.toString());
                responseApi=new ResponseApi(false,"myUser Not Found",new Date().toString(),null);
                model.addAttribute("responseApi", responseApi);
                return "error/error-404";
            }
            else if(statusCode == HttpStatus.FORBIDDEN.value()) {
                final Throwable error = errorAttributes.getError(webRequest);
                responseApi=new ResponseApi(false,"Forbidden Access",new Date().toString(),null);
                model.addAttribute("responseApi", responseApi);
                return "error/error-403";
            }

            else if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                final Throwable error = errorAttributes.getError(webRequest);
                responseApi=new ResponseApi(false,"Internal Server Error",new Date().toString(),null);
                model.addAttribute("responseApi", responseApi);
                return "error/error-500";
            }


        }

        return "error/error";
    }


}
