package com.camp.cammvc.controller;

import com.camp.cammvc.entity.ResponseApi;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorHandler implements ErrorController {


    @RequestMapping("/error")
    public String handleError(Model model, ResponseApi responseApi, HttpServletRequest request) {
        //do something like logging
        model.addAttribute("responseApi", responseApi);
        return "error";
    }


    @Override
    public String getErrorPath() {
        return null;
    }
}
