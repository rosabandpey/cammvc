package com.camp.cammvc.controller;


import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.service.UserApiServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;

@Controller

public class UserController {


    @Autowired
    private UserApiServiceImpl userApiService;

    @GetMapping
    public String getByUsername(@RequestParam("username")String username){

        userApiService.getByUsername(username);
        return "responseApi";
    }

}
