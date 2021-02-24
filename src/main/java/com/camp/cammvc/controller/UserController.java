package com.camp.cammvc.controller;


import com.camp.cammvc.entity.AppUser;
import com.camp.cammvc.entity.ResponseApi;
import com.camp.cammvc.exception.ApiException;
import com.camp.cammvc.service.UserApiServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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


    @GetMapping("/getUser")
    public String getByUsername(@PathVariable("username") String username,Model model){
        ResponseApi responseApi=userApiService.getByUsername(username);

        model.addAttribute("responseApi",responseApi );
        //model.addAttribute("getUser",userApiService.getByUsername(username));
        return "user";
    }


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



    @RequestMapping(path="/create",method = {RequestMethod.POST}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public String register(Model model, AppUser appUser)  {
       // model.addAttribute("responseApi", responseApi);
        userApiService.register(appUser) ;
        return "redirect:/allUser";
    }



}
