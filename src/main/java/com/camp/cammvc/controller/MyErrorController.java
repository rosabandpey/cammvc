package com.camp.cammvc.controller;

import com.camp.cammvc.entity.ResponseApi;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model, ResponseApi responseApi, HttpServletRequest request) {
        //do something like logging
        model.addAttribute("responseApi", responseApi);
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());

            if (statusCode == HttpStatus.BAD_REQUEST.value()) {
                responseApi.setMessage("you are");
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                responseApi.getMessage();
            }
        }
            return "error";
        }


    @Override
    public String getErrorPath() {
        return null;
    }
}
