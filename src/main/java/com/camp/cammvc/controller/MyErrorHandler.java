package com.camp.cammvc.controller;

import com.camp.cammvc.entity.ResponseApi;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorHandler implements ErrorController {

    private final ErrorAttributes errorAttributes;

    public MyErrorHandler(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public String handleError(Model model, ResponseApi responseApi,  WebRequest request) {
        //do something like logging
        model.addAttribute("responseApi", responseApi);
        final Throwable error = errorAttributes.getError(request);
        model.addAttribute("exception", error);
        return "error";
    }


    @Override
    public String getErrorPath() {
        return "/error";
    }
}
