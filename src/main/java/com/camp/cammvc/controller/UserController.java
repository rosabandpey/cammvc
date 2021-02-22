package com.camp.cammvc.controller;


import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.service.UserApiServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserApiServiceImpl userApiService;


   /* @GetMapping
    public String getByUsername(@PathParam("username") String username,Model model){

        model.addAttribute("responseApi",userApiService.getByUsername(username));
        return "responseApi";
    }  */


    @GetMapping("/allUser")
    public String getAllUsers(Model model){

        model.addAttribute("users",userApiService.getAllUsers());
        return "users";
    }

  /*  @GetMapping("/add-edit-user")
    public String create(){


        return "add-edit-user";
    } */


    @RequestMapping(path = {"/edit", "/edit/{id}"},method = {RequestMethod.GET,RequestMethod.POST})
    public String editUserById(Model model,AppUser appUser)

    {


        model.addAttribute("appUser", appUser);

        return "add-edit-user";
    }

    @RequestMapping(path="/create",method = {RequestMethod.GET,RequestMethod.POST})
    public String register(Model model,AppUser appUser) throws JsonProcessingException {
        model.addAttribute("appUser",model);
        userApiService.register(appUser) ;
        return "redirect:/";
    }



}
